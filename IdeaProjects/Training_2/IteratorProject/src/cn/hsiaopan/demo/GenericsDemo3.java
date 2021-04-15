package cn.hsiaopan.demo;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo3 {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        List<Integer> age = new ArrayList<>();
        List<Number> number = new ArrayList<>();

        name.add("icon");
        age.add(18);
        number.add(314);

        getData(name); // 此处用getUpperNumber会报错，String类型不在此泛型范围内
        getUpperNumber(age);
        getUpperNumber(number);
    }

    public static void getData(List<?> data) { // 类型通配符一般是使用 ? 代替具体的类型参数
        System.out.println("data: " + data.get(0));
    }

    // 类型通配符上线通过形如List来定义，如此定义就是通配符泛型值接受 Number 及其下层子类型
    public static void getUpperNumber(List<? extends Number> data) {
        System.out.println("data: " + data.get(0));
    }
}
