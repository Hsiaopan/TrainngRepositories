package cn.hsiaopan.demo;

public class WhileDemo1 {
    public static void main(String[] args) {
        // 需求：打印5次Hello World

        for(int i = 1; i <= 5; i++){
            System.out.println("Hello World");
        }
        System.out.println("-----------------");

        int j = 1;
        while (j <= 5){
            System.out.println("Hello World");
            j++;
        }
        System.out.println("------------------");
    }
}
