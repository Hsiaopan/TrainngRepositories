package cn.hsiaopan.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterateArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("HAHAHAHA");

        // 第一种遍历方法 使用 for-each 遍历 List
        for (String str :
                list) {
            System.out.println(str);
        }

        // 第二种遍历方法 把链表变为数组相关的内容进行遍历
        String[] strArray = new String[list.size()];
        list.toArray(strArray);
        for (String str :
                strArray) {
            System.out.println(str);
        }

        // 第三种遍历方法 使用迭代器进行相关遍历
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) { // 判断下一个元素之后有值
            System.out.println(iter.next());
        }

    }
}


