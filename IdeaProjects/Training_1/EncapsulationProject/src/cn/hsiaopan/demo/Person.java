package cn.hsiaopan.demo;

/*
    封装是指一种将抽象性函式接口的实现细节部分包装、隐藏起来的方法。
    封装可以被认为是一个保护屏障，防止该类的代码和数据被外部类定义的代码随机访问。
    要访问该类的代码和数据，必须通过严格的接口控制。
    封装最主要的功能在于我们能修改自己的实现代码，而不用修改哪些调用我们代码的程序片段。

    封装的优点：
        良好的封装能够减少耦合
        类内部的结构可以自由修改
        可以对成员你变量进行更精确的控制
        隐层信息，实现细节
 */

public class Person {
    // 将成员对象属性设置为私有的，只能本类才能访问。
    private String name;
    private int age;

    /*
        对每个值属性提供对外的公共方法访问，也就是创建一对赋值取值方法，用于对私有属性的访问。
     */
    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }
}
