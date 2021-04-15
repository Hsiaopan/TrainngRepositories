package cn.hsiaopan.demo;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Google");
        linkedList.add("Bing");
        linkedList.add("Baidu");
        linkedList.add("Tencent");
        linkedList.add("Alibaba");
        System.out.println(linkedList);

        // 使用addFirst() 在头部添加元素
        linkedList.addFirst("Wiki");

        // 使用addLast() 在尾部添加元素
        linkedList.addLast("PDD");
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

        // 获取头部元素
        System.out.println(linkedList.getFirst());

        // 获取尾部元素
        System.out.println(linkedList.getLast());

    }
}
