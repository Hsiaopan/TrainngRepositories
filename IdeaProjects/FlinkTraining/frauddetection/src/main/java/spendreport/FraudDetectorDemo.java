package spendreport;

import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.util.Collector;
import org.apache.flink.walkthrough.common.entity.Alert;
import org.apache.flink.walkthrough.common.entity.Transaction;

/*
 * 功能要求：
 *     对于一个账户，如果出现小于1美元的交易后紧跟着一个大于500美元的交易，就输出一个报警信息
 *
 * 欺诈检测器需要再多个交易时间之间记住一些信息。仅当月一个大额的交易金穗一个小额交易的情况发生时，这个大额交易才被认为是欺诈交易。
 * 在多个事件之间存储信息就需要使用到 “状态”，这也是选择使用 KeyedProcessFunction 的原因。它能够同时提供对状态和时间的细粒度操作，
 * 这使得我们能够在接下来的代码练习中实现更复杂的算法。
 * 
 * 最直接的实现方式是使用一个 Boolean 型的标记状态来表示是否刚处理过一个小额交易。当处理到该账户的一个大额交易时，只需要检测这个标记
 * 状态来确认上一个交易是否小额交易即可。
 *
 * 然而，仅使用一个标记作为FraudDetector的类成员来记录账户的上一个交易状态是不准确的。Flink 会在同一个FraudDetector 的并发实例中
 * 处理多个账户的交易数据。虽然可以使用如Map 这样的数据结构来保存没一个账户的状态，但是常规的类成员变量是无法做到容错处理的，当任务失
 * 败重启后，之前的状态信息将会丢失。
 *
 * 为了应对这个问题，Flink 提供了一套支持容错状态的原语。
 * Flink中最基础的状态类型是ValueState ，这是一种能够为被其封装的变量添加容错能力的类型。
 * ValueState是一种 keyed state，也就是说它只能被用于 Keyed context提供的 operator中，即素哟有能能够紧随DataStream#keyBy之
 * 后调用的operator。一个operator中的keyed state 的作用域默认是属于它所属的key的。
 * ValueState 需要使用ValueStateDescriptor 来创建，ValueStateDescriptor 包含了Flink 如何管理变量的一些元数据信息。
 * 状态在使用之前需要先被注册。状态需要使用 open() 函数来注册状态。
 */

public class FraudDetectorDemo extends KeyedProcessFunction<Long, Transaction, Alert> {

    private static final long serialVersionUID = 1L;

    private static final double SMALL_AMOUNT = 1.00;
    private static final double LARGE_AMOUNT = 500.00;
    private static final long ONE_MINUTE = 60 * 1000;

    private transient ValueState<Boolean> flagState;
    private transient ValueState<Long> timerState;

    /*
     * 要求：
     *    当标记状态被设置为true时，设置一个在当前时间一分钟触发的定时器。
     *    当定时器被触发时，重置标记状态
     *    当标记状态别重置时，删除定时器
     * 要删除一个定时器，你需要记录这个定时器的触发时间，这同样需要状态来实现。
     * 所以需要在标记状态后也创建一个记录定时器的状态  
     */

    // 使用 open() 函数来注册状态
    /*
     * ValueState 是一个包装类，它提供了三个用于交互的方法。
     *      update 用于更新状态
     *      value 用于获取状态值
     *      clear 用于清空状态
     * 如果一个key 还没有状态，如程序刚启动或调用过clear方法时，ValueState#value 将会返回 null。
     * 如果需要更新状态，需要调用ValueState#update 方法，直接更改ValueState#value 的返回值可能不会被系统识别。
     * 容错处理将在Flink 后台自动管理。
     */
    @Override
    public void open(Configuration parameters){
        ValueStateDescriptor<Boolean> flagDescriptor = new ValueStateDescriptor<>(
                "flag",
                Types.BOOLEAN);
        flagState = getRuntimeContext().getState(flagDescriptor);

        ValueStateDescriptor<Long> timerDescriptor = new ValueStateDescriptor<>(
                "timer-state",
                Types.LONG);
        timerState = getRuntimeContext().getState(timerDescriptor);
    }

    @Override
    public void processElement(
            Transaction transaction,
            Context context,
            Collector<Alert> collector) throws Exception{
        
        // get the current state for the current key
        Boolean lastTransactionWasSmall = flagState.value();

        // check if the flag is set
        if(lastTransactionWasSmall != null){
            if(transaction.getAmount() > LARGE_AMOUNT){
                //output an alert downstream
                Alert alerts = new Alert();
                alerts.setId(transaction.getAccountId());

                collector.collect(alerts);
            }

            // clean up our state
            flagState.clear();
        }

        /*
         * KeyedProcessFunction#processElement 需要使用定时器的Context 来调用。
         * 定时器服务可以用于查询当前时间、注册定时器和删除定时器。
         * 使用它，你可以再标记状态被设置时，也设置一个当前时间一分钟后触发的定时器，
         * 同事，将触发时间保存到timerState 状态中
         */
        if(transaction.getAmount() < SMALL_AMOUNT){
            // set the flag to true
            flagState.update(true);

            // set the timer and timer state
            long timer = context.timerService().currentProcessingTime() + ONE_MINUTE;
            context.timerService().registerProcessingTimeTimer(timer);
            timerState.update(timer);
        }

    }

    /*
     * 处理时间是本地时钟时间，这是由运行任务的服务器的系统时间来决定的
     * 当定时器触发时，将会调用KeyedProcessFunction#onTimer 方法。
     * 通过重写这个方法来实现一个你自己的重置状态的回调逻辑
     */
    public void onTimer(Long timestamp, OnTimerContext ctx, Collector<Alert> out){
        // remove flag after 1 minute
        timerState.clear();
        flagState.clear();
    }

    /*
     * 如果要取消定时器，需要删除已经注册的定时器，并同时清空保存定时器的状态。
     * 把这个逻辑封装在一个助手函数里，而不是直接调用flagState.clear()
     */ 
    private void cleanUp(Context ctx) throws Exception{
        // delete timer
        Long timer = timerState.value();
        ctx.timerService().deleteProcessingTimeTimer(timer);

        // clean up all state
        timerState.clear();
        flagState.clear();
    }
}