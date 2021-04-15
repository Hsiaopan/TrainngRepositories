package cn.hsiaopan.demo;

public class ArrayDemo5 {
    public static void main(String[] args) {
        // 定义打印数组元素的方法并调用
        // 定义一个数组
        int[] arr = {2,4,5,6,9,1,11};

        // 调用方法
        printArray(arr);
    }

    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
