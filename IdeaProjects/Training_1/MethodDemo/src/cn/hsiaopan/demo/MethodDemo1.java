package cn.hsiaopan.demo;

import java.util.Scanner;

public class MethodDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("输入第一个数字");
        int a = sc.nextInt();

        System.out.println("输入第二个数字");
        int b = sc.nextInt();

        // 调用方法
        int s = sum(a, b);
        System.out.println("两数之和为：" + s);
    }

    /*
        注意：方法和方法之间是平级的关系，不能嵌套定义
             要定义方法，注意三个明确：
                 明确方法名
                 明确返回值的类型
                 明确参数列表
     */

    // 需求：定义一个方法，用来获取两个整数的和
    public static int sum(int a, int b) {
        // 方法体语句，其实就是具体的运算过程
        int c = a + b;
        return c;
    }
}
