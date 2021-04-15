package cn.hsiaopan.demo;

public class ArrayDemo4 {
    public static void main(String[] args) {
        // 获取数组中的最大值
        int[] arr = new int[]{2,4,6,7,17,7,9,2,3,11,10};

        int t = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > t){
                t = arr[i];
            }

        }
        System.out.println("数组中最大元素为: " + t);
    }
}
