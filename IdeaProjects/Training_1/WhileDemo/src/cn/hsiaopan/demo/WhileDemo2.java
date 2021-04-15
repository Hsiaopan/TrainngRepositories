package cn.hsiaopan.demo;

public class WhileDemo2 {
    public static void main(String[] args) {
        // 需求：求1-100之间的数据和
        // 定义求和变量

        int sum = 0;
        int i = 1;

        while(i <= 100){
            sum += i;
            i++;
        }
        System.out.println("1-100的和为：" + sum);

    }
}
