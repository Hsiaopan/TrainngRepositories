package cn.hsiaopan.demo;

import java.util.Scanner;

public class MethodDemo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入第一个数字");
        int a = sc.nextInt();

        System.out.println("请输入第二个数字");
        int b = sc.nextInt();

        boolean r = compare(a, b);
        System.out.println(r);


    }

    public static boolean compare(int a, int b){
        return a == b;
    }
}
