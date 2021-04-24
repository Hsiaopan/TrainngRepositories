package cn.hsiaopan.learnjava;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] array = new String[]{"apple", "Orange", "banana", "Lemon"};

//        Arrays.sort(array, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareToIgnoreCase(o2);
//            }
//        });

        /**
         * lambda 表达式
         */
        Arrays.sort(array, (s, str) -> s.compareToIgnoreCase(str));
        System.out.println(String.join(", ", array));
    }
}
