package cn.hsiaopan.demo;

import java.util.Random;
import java.util.Scanner;

public class RandomWhileDemo {
    public static void main(String[] args) {
        // 系统产生一个1-100之间的随机数，猜测这个数字
        Random r = new Random();
        int t = r.nextInt(100) + 1;

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数进行猜测：");
        int s = sc.nextInt();
        while (s != t){
            if(s > t){
                System.out.println("大了，请重试");
            }else{
                System.out.println("小了，请重试");
            }
            s = sc.nextInt();
        }
        System.out.println("恭喜你猜对了");
    }
}
