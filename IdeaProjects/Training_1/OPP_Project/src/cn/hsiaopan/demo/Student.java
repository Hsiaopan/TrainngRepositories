package cn.hsiaopan.demo;

public class Student {
    // 构造方法
    // 无参构造
    public Student(){};

    public Student(String name, Integer age){
        this.name = name;
        this.age = age;
    };
    // 姓名
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    // 年龄
    private Integer age;

    public void setAge(Integer age){
        this.age = age;
    }

    public Integer getAge(){
        return age;
    }

    // 学习
    public void study(){
        System.out.println(name + "正在学习...");
    }

    public void show(){

        /*
            局部变量跟成员变量，用this区分，this取用成员的
         */
        int age = 24;
        System.out.println(age);
        System.out.println(this.age);
    }

}
