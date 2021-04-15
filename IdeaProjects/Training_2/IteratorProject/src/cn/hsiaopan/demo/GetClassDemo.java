package cn.hsiaopan.demo;

import java.util.ArrayList;

public class GetClassDemo {
    public static void main(String[] args) {
        // getClass() with Object
        Object object = new Object();
        System.out.println("Object 的类为：" + object.getClass());

        // getClass() with String
        String string = new String();
        System.out.println("String 的类为：" + string.getClass());

        // getClass() with ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println("ArrayList 的类为：" +  arrayList.getClass());

        GetClassDemo obj = new GetClassDemo();
        System.out.println(obj.getClass()); // 自定义类调用getClass()方法
    }
}
