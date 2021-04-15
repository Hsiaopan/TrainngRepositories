package cn.hsiaopan.demo;

public class ForDemo4 {
    public static void main(String[] args) {
        // 需求 求出1-100之间的偶数的和
        // 定义一个求和变量
        int sum = 0;

        // 获取1-100之间所有的数据
        for(int i = 1; i <= 100; i++){
            if(i % 2 == 0){
                sum += i;
            }
        }
        System.out.println(sum);

    }
}
