package cn.hsiaopan.demo;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> arrlist = new ArrayList<>();
        arrlist.add("Google");
        arrlist.add("Bing");
        arrlist.add("Baidu");
        arrlist.add("Tencent");
        arrlist.add("Alibaba");

        System.out.println(arrlist);

        System.out.println(arrlist.get(1)); //访问元素

        arrlist.set(2,"PDD");  // 修改元素，第一个参数为索引位置
        System.out.println(arrlist);

        arrlist.remove(4); //删除元素
        System.out.println(arrlist);

        System.out.println(arrlist.size()); //计算大小

        Collections.sort(arrlist); // 字母排序
        // 迭代数组列表
        for (String arr:
             arrlist) {
            System.out.println(arr);
        }
    }
}
