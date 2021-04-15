package cn.hsiaopan.demo;

/*
    手机类的测试类
 */
public class TestPhone {
    public static void main(String[] args) {
        // 创建对象
        Phone p = new Phone();

        // 调用成员对象，并打印
        // 给成员变量赋值
        p.brand = "Apple";
        p.model = "X";
        p.name = "程序猿";

        //打印成员变量的值
        System.out.println(p.brand);
        System.out.println(p.name);
        System.out.println(p.model);

        // 调用方法
        System.out.println("--------");
        p.call("乔布斯");
        p.sendMessage();
        p.playGame();
    }
}
