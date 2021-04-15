package myflink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class SocketStreamWordCount {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        final String host = "localhost";
        final int port = 9000;

        DataStreamSource<String> source = env.socketTextStream(host, port);

        source
                .flatMap((FlatMapFunction<String, Tuple2<String, Integer>>) SocketStreamWordCount::flatMap)
                .keyBy(v -> v.f0)
                .sum(1)
                .print();

        env.execute();
    }

    public static void flatMap(String s, Collector<Tuple2<String, Integer>> collector) {
        for (String word :
                s.split(" ")) {
            collector.collect(new Tuple2<>(word, 1));
        }

    }

}
