package cn.hsiaopan.demo;

import java.util.Random;
import java.util.Scanner;


public class WhileDemoIns {
    public static void main(String[] args) {
        Random r = new Random();
        int k = r.nextInt(100);

        System.out.println("已经生成一个随机数，请猜测：");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        while (i != k) {
            if (i < k) {
                System.out.println("小了，请继续尝试：");
            } else {
                System.out.println("大了，请继续尝试：");
            }
            i = sc.nextInt();
        }
        System.out.println("恭喜猜对了！");
    }
}
