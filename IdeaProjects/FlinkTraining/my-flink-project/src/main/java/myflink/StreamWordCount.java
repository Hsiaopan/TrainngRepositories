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
import org.apache.flink.util.Collector;


public class StreamWordCount {
    public static void main(String[] args) throws Exception{
        // 创建环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // 从文件中获取数据源
        final String fileName = "/Users/hsiaopan/IdeaProjects/OtherDocs/word-counts.txt";
        DataStream<String> source = env.readTextFile(fileName);

        // 单词计数
        source
                // 将一行句子按照空格拆分，输入一个字符串，输出一个2元组，key为单词，value为1
                .flatMap((FlatMapFunction<String, Tuple2<String, Integer>>) StreamWordCount::flatMap)
                // 聚合算子，按照一个字段进行分组
                .keyBy(v -> v.f0)
                .sum(1)
                .print();

        env.execute();


    }

    public static void flatMap(String s, Collector<Tuple2<String, Integer>> collector) {
        String[] split = s.split(" ");
        for (String word:
             split) {
            collector.collect(new Tuple2<>(word, 1));
        }
    }
}
