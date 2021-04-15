package cn.hsiaopan.demo;

import java.util.Scanner;

public class IfDemo4 {
    public static void main(String[] args) {
        // 需求：键盘录入两个数据，获取这两个数据的最大值
        // 1. 创建键盘录入对象
        Scanner sc = new Scanner(System.in);

        // 2. 提示用户录入两个整数，并接收
        System.out.println("请录入第一个整数：");
        int a = sc.nextInt();
        System.out.println("请录入第二个整数：");
        int b = sc.nextInt();

        // 3. 定义变量，记录最大值
        int max;

        // 4. 通过if语句判断两个整数的最大值
        if(a > b){
            max = a;
        }else{
            max = b;
        }

        // 5. 将结果打印出来
        System.out.println("最大值是：" + max);
    }
}
