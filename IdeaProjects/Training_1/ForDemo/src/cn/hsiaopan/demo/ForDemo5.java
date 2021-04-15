package cn.hsiaopan.demo;

public class ForDemo5 {
    public static void main(String[] args) {
        // 水仙花数
        int count = 0;

        for(int i = 100; i <= 999; i++){
             int a = i/100;
             int b = i/10 % 10;
             int c = i % 10;
             if(a*a*a + b*b*b + c*c*c == i){
                 System.out.println(i);
                 ++count;
             }
        }
        System.out.println(count);
    }
}
