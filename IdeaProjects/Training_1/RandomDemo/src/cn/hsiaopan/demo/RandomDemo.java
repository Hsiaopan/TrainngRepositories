package cn.hsiaopan.demo;

import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        // 获取一个随机数
        Random r = new Random();

        for(int i = 0; i < 10; i++){
            int num = r.nextInt(10);
            System.out.println(num);
        }

    }
}
