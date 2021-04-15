package cn.hsiaopan.demo;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Google");
        arrayList.add("Bing");
        arrayList.add("Baidu");
        arrayList.add("Bing");
        arrayList.add("Tencent");
        arrayList.add("Alibaba");

        System.out.println(arrayList);

        // 获取迭代器
        Iterator<String> iterator = arrayList.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(8);
        numbers.add(15);
        numbers.add(23);
        numbers.add(9);
        numbers.add(27);

        Iterator<Integer> integerIterator = numbers.iterator();
        while (integerIterator.hasNext()){
            Integer i = integerIterator.next();
            if (i < 10){
                integerIterator.remove(); // 删除小于10的元素
            }
        }
        System.out.println(numbers);

        /*
            numbers.removeIf(i -> i < 10) 或者这种写法
         */
    }
}
