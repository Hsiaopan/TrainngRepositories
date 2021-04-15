package cn.hsiaopan.demo;

public class ArrayDemo3 {
    public static void main(String[] args) {
        /*
            需求： 给定一个int型数组，输出数组中的每一个元素
         */

        // 定义一个长度为5的int型数组
        int[] arr = new int[5];

        // 给前个元素赋值
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;

        // for循环遍历出数组
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }
    }
}
