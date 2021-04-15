/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package myflink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

public class SocketWindowWordCount {
    public static void main(String[] args) throws Exception {
        // 创建 Execution Env
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();


        // 通过连接 socket 获取输入数据，这里连接本地9000端口
        DataStream<String> text = env.socketTextStream("localhost", 9000, "\n");

        // operation
        DataStream<Tuple2<String, Integer>> windowCounts = text
                .flatMap((FlatMapFunction<String, Tuple2<String, Integer>>) SocketWindowWordCount::flatMap)
                .keyBy(v -> v.f0)
                // 每1分钟
                .window(TumblingEventTimeWindows
                        .of(Time.minutes(1)))
                .sum(1);

        windowCounts.print().setParallelism(1);

        env.execute("Socket Window WordCount");
    }

    private static void flatMap(String s, Collector<Tuple2<String, Integer>> collector) {
        for (String word :
                s.split("\\s")) {
            collector.collect(Tuple2.of(word, 1));
        }
    }
}
