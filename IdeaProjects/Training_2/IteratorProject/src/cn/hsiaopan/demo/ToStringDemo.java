package cn.hsiaopan.demo;

public class ToStringDemo {
    public static void main(String[] args) {
        // 返回对象的 Class 名称 + @ + hashCode的16进制字符串
        // toString() with Object
        Object obj1 = new Object();
        System.out.println(obj1.toString());

        Object obj2 = new Object();
        System.out.println(obj2.toString());

        Object obj3 = new Object();
        System.out.println(obj3.toString());


        // toString() with Array
        String[] array = {"Google", "Bing", "Tencent"};
        System.out.println(array.toString());

        // 数组元素值返回一个字符串的表示形式
        // Array 继承了Object 类，所以可以直接用toString()方法
        System.out.println(array[1].toString());
    }
}
