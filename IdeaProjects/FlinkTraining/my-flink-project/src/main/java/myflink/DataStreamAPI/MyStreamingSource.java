package myflink.DataStreamAPI;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import myflink.DataStreamAPI.MyStreamingSource.Item;

import java.util.Random;

public class MyStreamingSource implements SourceFunction<MyStreamingSource.Item> {
    private boolean isRuning = true;
    /**
     *  重写run方法产生源源不断的数据发送源
     */
    @Override
    public void run(SourceContext<Item> ctx) throws Exception {
        while (isRuning) {
            Item item =generateItem();
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

        return  item;
    }


    class Item{
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
        SingleOutputStreamOperator<Object> mapItems;
        mapItems = itemDataStreamSource.map((MapFunction<MyStreamingSource.Item, Object>) Item::getName);

        // 打印结果
        mapItems.print().setParallelism(1);
        String jobName = "user defined streaming source";
        env.execute(jobName);

    }
}