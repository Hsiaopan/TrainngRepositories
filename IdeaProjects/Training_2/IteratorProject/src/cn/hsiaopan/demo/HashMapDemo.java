package cn.hsiaopan.demo;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "Google");
        hashMap.put(2, "Bing");
        hashMap.put(3, "Baidu");
        hashMap.put(4, "Bing");
        hashMap.put(5, "Tencent");
        System.out.println(hashMap);

        // 访问元素
        System.out.println(hashMap.get(4));

        // 删除元素
        hashMap.remove(2);
        System.out.println(hashMap);

        // 计算大小
        System.out.println(hashMap.size());

        // 迭代 key value
        for (Integer i:
                hashMap.keySet()) {
            System.out.println("key: " + i + " value: " + hashMap.get(i));
        }

        // 返回所有value
        for (String value:
                hashMap.values()) {
            System.out.println(value + ", ");
        }

        hashMap.clear(); // 清空
        System.out.println(hashMap);
    }
}
