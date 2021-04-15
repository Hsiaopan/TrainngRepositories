package cn.hsiaopan.demo;

import java.util.ArrayList;

public class HashCodeDemo {
    public static void main(String[] args) {
        // Object 使用 hashCode()
        Object obj1 = new Object();
        System.out.println(obj1.hashCode());

        Object obj2 = new Object();
        System.out.println(obj2.hashCode());

        Object obj3 = new Object();
        System.out.println(obj3.hashCode());

        // String和ArrayList类使用 hashCode()
        String str = new String();
        System.out.println(str.hashCode());  // 0

        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println(arrayList.hashCode()); // 1

        Object object1 = new Object();
        Object object2 = object1;

        // 判断是否相等
        System.out.println(object1.equals(object2)); // true

        // 获取哈希值
        System.out.println(object1.hashCode());
        System.out.println(object2.hashCode());
    }
}
