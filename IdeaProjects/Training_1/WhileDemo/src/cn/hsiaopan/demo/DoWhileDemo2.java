package cn.hsiaopan.demo;

public class DoWhileDemo2 {
    public static void main(String[] args) {
        // 三种循环的区别

        // for循环
        for(int a = 1; a <= 5; a++){
            System.out.println("a:" + a);
        }
        System.out.println("------------");

        // while循环
        int b = 1;
        while(b <= 5){
            System.out.println("b:" + b);
            b++;
        }
        System.out.println("------------");

        // do...while循环
        int c = 1;
        do{
            System.out.println("c:" + c);
            c++;
        }while(c <= 5);
        System.out.println("------------");
    }
}
