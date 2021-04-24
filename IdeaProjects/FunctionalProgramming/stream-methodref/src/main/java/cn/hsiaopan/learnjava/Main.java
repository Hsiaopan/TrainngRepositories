package cn.hsiaopan.learnjava;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] array = new String[]{"apple", "Orange", "banana", "Lemon"};

        /*
          使用方法引用
         */
        Arrays.sort(array,
                String::compareToIgnoreCase);

        System.out.println(String.join(", ", array));
    }
}
