package cn.hsiaopan.demo;

public class OperatorDemo3 {
    public static void main(String[] args) {
        // 需求： 求两个整数的最大值
        // 1. 定义两个变量记录了两个整数
        int a = 30;
        int b = 24;

        // 2. 经过三元运算符计算他们的最大值
        int max = (a >= b) ?a : b;
        System.out.println(max);
    }
}
