package cn.hsiaopan.demo;

// 1.导包
import java.util.Scanner;

public class ScannerDemo2 {
    public static void main(String[] args) {
        // 创建键盘录入对象
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个整数：");
        int a = sc.nextInt();

        System.out.println("请再输入一个整数：");
        int b = sc.nextInt();

        int sum = a + b;
        System.out.println(sum);
    }
}
