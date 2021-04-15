package cn.hsiaopan.demo;

public class ForDemo3 {
    public static void main(String[] args) {
        // 需求： 计算1~5之间的所有数之和

        int sum = 0;

        for(int i = 1; i <= 5; i++){
            sum += i;
        }
        System.out.println(sum);
    }
}
