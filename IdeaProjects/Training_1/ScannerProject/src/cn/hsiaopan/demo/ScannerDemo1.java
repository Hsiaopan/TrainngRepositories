package cn.hsiaopan.demo;

// 1.导包
import java.sql.SQLOutput;
import java.util.Scanner;

public class ScannerDemo1 {
    public static void main(String[] args) {
        // 2. 创建键盘录入对象
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个整数：");
        // 3.接收数据
        int i = sc.nextInt();

        System.out.println(i);
    }
}