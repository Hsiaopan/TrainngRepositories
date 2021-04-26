package cn.hsiaopan.learnjava;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws Exception{
        String[] strings = new String[]{"2021- 01-03","2021-02- 07","2021- 02- 27","2021-03 -09","2021- 04 -25"};

        Arrays.stream(strings)
                .map(s -> s.replaceAll("\\s+", "")) // 正则表达式替换所有空格
                .map(LocalDate::parse)  // 引用LocalDate方法把string转成LocalDate
                .forEach(System.out::println);

    }
}
