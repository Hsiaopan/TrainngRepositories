package cn.hsiaopan.demo;

public class CloneObjectDemo implements Cloneable{
    public String name;
    public int likes;

    public static void main(String[] args) {
        // 创建对象
        CloneObjectDemo objectDemo1 = new CloneObjectDemo();

        // 初始化变量
        objectDemo1.name = "Hanpi";
        objectDemo1.likes = 13;

        System.out.println(objectDemo1.name);
        System.out.println(objectDemo1.likes);

        try{
            // 创建objectDemo1的拷贝
            CloneObjectDemo objectDemo2 = (CloneObjectDemo) objectDemo1.clone();

            // 使用objectDemo2输出变量
            System.out.println(objectDemo2.name);
            System.out.println(objectDemo2.likes);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
