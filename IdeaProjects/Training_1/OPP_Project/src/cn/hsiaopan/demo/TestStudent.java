package cn.hsiaopan.demo;

/*
    构造方法:
        构造方法名必须和类名相同（包括大小写）
        构造方法没有返回值（但是里面可以写return）
        构造方法没有返回值类型（连void都没有）

    注意：
        若未提供任何构造方法，系统会给出默认无参构造
        若已提供任何构造方法，系统不会提供无参构造
        构造方法可以重载
 */

import javax.swing.plaf.synth.SynthTableHeaderUI;

public class TestStudent {
    public static void main(String[] args) {
        /*
            private:
                概述：
                    一种访问权限修饰符，用来修饰类的成员
                特点：
                    被他修饰的成员只能在本类中访问
                结论：
                    private一般用来修饰成员变量
                    public一般用来修饰成员方法

         */

        // 需求： 定义一个姓名叫张三的年龄为23的学生
        Student stu1 = new Student();

        stu1.setName("张三");
        stu1.setAge(23);

    //    s.show();
        System.out.println(stu1.getName());
        System.out.println(stu1.getAge());
        stu1.study();

        Student stu2 = new Student("李四",25);
        System.out.println(stu2.getName());
        System.out.println(stu2.getAge());
    }
}
