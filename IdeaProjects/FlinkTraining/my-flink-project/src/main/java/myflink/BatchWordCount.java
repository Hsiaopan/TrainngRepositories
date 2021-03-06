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
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;


public class BatchWordCount {
    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        final String fileName = "/Users/hsiaopan/Repositories/IdeaProjects/OtherDocs/word-counts.txt";
        DataSource<String> dataSource = env.readTextFile(fileName);

        dataSource
                .flatMap((FlatMapFunction<String, Tuple2<String, Integer>>) BatchWordCount::flatMap)
                .groupBy(0)
                .sum(1)
                .print();
    }

    private static void flatMap(String s, Collector<Tuple2<String, Integer>> collector) {
        String[] split = s.split(" ");
        for (String word :
                split) {
            collector.collect(new Tuple2<>(word, 1));

        }
    }
}
