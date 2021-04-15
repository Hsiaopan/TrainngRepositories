package cn.hsiaopan.demo;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo1 {
    public static void main(String[] args) {
        ArrayList<Integer> myNumbers = new ArrayList<>();
        myNumbers.add(9);
        myNumbers.add(15);
        myNumbers.add(13);
        myNumbers.add(20);
        myNumbers.add(5);
        myNumbers.add(17);

        Collections.sort(myNumbers); //数字排序

        for (int i:
             myNumbers) {
            System.out.println(i);
        }
    }
}
