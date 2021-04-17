package myflink.DataStreamAPI;


import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.util.Collector;

import java.util.Random;

public class MyStreamingSource implements SourceFunction<MyStreamingSource.Item> {
    private boolean isRuning = true;

    /**
     * 重写run方法产生源源不断的数据发送源
     */
    @Override
    public void run(SourceContext<Item> ctx) throws Exception {
        while (isRuning) {
            Item item = generateItem();
            ctx.collect(item);

            // 每秒产生一条数据
            Thread.sleep(1000);
        }
    }

    @Override
    public void cancel() {
        isRuning = false;
    }

    // 随机产生一条商品数据
    private Item generateItem() {
        int i = new Random().nextInt(100);

        Item item = new Item();
        item.setName("name" + i);
        item.setId(i);

        return item;
    }


    class Item {
        private String name;
        private Integer id;

        public Item() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }
}

class StreamingDemo {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // 获取数据源
        DataStreamSource<MyStreamingSource.Item> itemDataStreamSource;
        itemDataStreamSource = env.addSource(new MyStreamingSource()).setParallelism(1);

        // map
        SingleOutputStreamOperator<String> mapItems;
        mapItems = itemDataStreamSource.map(new MyMapFunction());

        // flatMap
        SingleOutputStreamOperator<Object> flatMapItems;
        flatMapItems = itemDataStreamSource
                .flatMap(new FlatMapFunction<MyStreamingSource.Item, Object>() {
                    @Override
                    public void flatMap(MyStreamingSource.Item item, Collector<Object> collector) throws Exception {
                        String name = item.getName();
                        collector.collect(name);
                    }
                })
        ;

        // filter
        SingleOutputStreamOperator<MyStreamingSource.Item> filterItems;
        filterItems = itemDataStreamSource.filter((FilterFunction<MyStreamingSource.Item>) item -> item.getId() % 2 == 0);

        /// 打印结果
        /// mapItems.print().setParallelism(1);
        /// flatMapItems.print();
        filterItems.print();
        String jobName = "user defined streaming source";
        env.execute(jobName);

    }

    static class MyMapFunction extends RichMapFunction<MyStreamingSource.Item, String> {

        @Override
        public String map(MyStreamingSource.Item item) throws Exception {
            return item.getName();
        }
    }
}