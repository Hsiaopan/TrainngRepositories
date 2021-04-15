package cn.hsiaopan.demo;

import java.util.Scanner;

public class IfDemo3 {
    public static void main(String[] args) {
        System.out.println("-----程序开始-----");

        Scanner sc = new Scanner(System.in);

        System.out.println("输入a的值：");
        int a = sc.nextInt();
        System.out.println("输入b的值：");
        int b = sc.nextInt();

        if(a > b){
            System.out.println(a + " 大于 " + b);
        }else if (a < b){
            System.out.println(a + " 小于 " + b);
        }else {
            System.out.println(a + " 等于 " + b);
        }

        System.out.println("-----程序结束-----");

    }
}
