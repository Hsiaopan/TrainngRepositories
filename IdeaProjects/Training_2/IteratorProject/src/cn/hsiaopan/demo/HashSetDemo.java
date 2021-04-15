package cn.hsiaopan.demo;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Google");
        hashSet.add("Bing");
        hashSet.add("Baidu");
        hashSet.add("Tencent");
        hashSet.add("Bing");
        hashSet.add("Alibaba");
        System.out.println(hashSet); // 每个元素都是唯一的、重复的不会被添加

        System.out.println(hashSet.contains("Tencent"));

        hashSet.remove("Baidu");
        System.out.println(hashSet);

        System.out.println(hashSet.size());

        for (String i:
             hashSet) {
            System.out.println(i);
        }

        hashSet.clear();
        System.out.println(hashSet);

    }
}
