
package spendreport;


import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.walkthrough.common.entity.Alert;
import org.apache.flink.walkthrough.common.entity.Transaction;
import org.apache.flink.walkthrough.common.sink.AlertSink;
import org.apache.flink.walkthrough.common.source.TransactionSource;


public class FraudDetectionJobDemo{
    public static void main(String[] args) throws Exception{
        // 创建一个上下文执行环境
        // 执行环境用于定义任务的属性、创建数据源以及最终启动任务的执行
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // 创建数据源
        // 数据源从外部系统如Kafka、Rabbit MQ或者Pulsar接收数据，然后将数据送到Flink程序中。
        // 绑定到数据源上的name属性，是为了调试方便，如果发生一些异常，我们能够通过它快速定位问题发生在哪里
        DataStream<Transaction> transactions = env
            .addSource(new TransactionSource())
            .name("transactions");

        // 对事件分区&欺诈检测
        /*
         * transactions这个数据流包含了大量的用户交易数据，需要划分到多个并发上进行欺诈检测处理。
         * 由于欺诈行为的发生是基于一个账户的。所以，必须要保证同一个账户的所有交易行为数据别同一个并发的task进行处理
         *
         * 为了保证同一个task处理同一个key的所有怇，可以通过DataStream#keyBy对流进行分区。
         * process() 函数对流绑定了一个操作，这个操作会对流上的每一个消息调用所定义好的函数。
         * 通常一个操作会紧跟着keyBy被调用。
         */
        DataStream<Alert> alerts = transactions
            .keyBy(transactions::getAccountId)
            .process(new FraudDetectorDemo())
            .name("fraud-detector");

        // 输出结果
        /*
         * sink会将DataStream写到外部系统，如Kafka、Cassandra或者AWS Kinessis等
         * AlertSink 使用INFO 的日志级别打印每个Alert的数据记录，而不是将其写入持久存储，以便可以方便地查看结果
         */

         alerts
             .addSink(new AlertSink())
             .name("send-alerts");

         // 运行作业
         // Flink程序是懒加载，并且只有在完全搭建好之后，才能够发布到集群上执行。
         env.execute("Fraud Detection");
    }
}