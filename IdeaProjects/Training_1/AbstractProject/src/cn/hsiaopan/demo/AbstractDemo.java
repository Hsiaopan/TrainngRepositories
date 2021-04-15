package cn.hsiaopan.demo;

/*
    如果一个类包含抽象方法，那么该类必须为抽象类
    任何子类必须重写父类的抽象方法，或者声明自身为抽象类

    抽象方法写法：
    public abstract double computePay();
 */
public class AbstractDemo {
    public static void main(String[] args) {
        Salary s = new Salary("Mohd Mohtashim","Ambehta, UP", 3, 5400.00);
        Employee e = new Salary("John Adams","Boston, Ma", 2, 4800.00);

        System.out.println("Call mailCheck using Salary reference ---");
        s.mailCheck();

        System.out.println("\nCall mailCheck using Employee reference ---");
        e.mailCheck();
    }
}
