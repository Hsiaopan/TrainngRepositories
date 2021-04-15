package cn.hsiaopan.demo;

public class ArrayDemo2 {
    public static void main(String[] args) {
        /*
            需求：打印数组中的指定元素
         */

        int[] arr = {11, 22, 44, 555};

        // 输出第三个元素的值
        System.out.println(arr[2]);

        // 给第1个元素重新赋值10
        arr[0] = 10;
        System.out.println(arr[0]);
    }
}
