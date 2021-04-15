package cn.hsiaopan.demo;

import java.util.Scanner;
public class IfDemo2 {
    public static void main(String[] args) {
        System.out.println("-------程序开始-------");

        Scanner sc = new Scanner(System.in);

        System.out.println("输入a的值：");
        int a = sc.nextInt();
        System.out.println("输入b的值：");
        int b = sc.nextInt();

        System.out.println("-------运算结果-------");

        if(a == b){
            System.out.println("a与b是相等的");
        }else{
            System.out.println("a与b是不相等的");
        }

        System.out.println("-------程序结束-------");
    }

}
