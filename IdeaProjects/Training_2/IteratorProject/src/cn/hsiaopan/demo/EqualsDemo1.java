package cn.hsiaopan.demo;

public class EqualsDemo1 {
    public static void main(String[] args) {
        // String 类使用 equals() 方法
        // 创建两个对象
        String obj1 = new String();
        String obj2 = new String();

        // 判断 obj1 与 obj2 是否相等
        // 初始化的连个对象都为null 所以是相等，返回true
        System.out.println(obj1.equals(obj2)); // true

        // 给对象赋值
        obj1 = "Google";
        obj2 = "Bing";

        System.out.println(obj1.equals(obj2)); // false
    }
}
