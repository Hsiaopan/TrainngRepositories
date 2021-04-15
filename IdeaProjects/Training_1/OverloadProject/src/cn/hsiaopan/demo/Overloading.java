package cn.hsiaopan.demo;

/*
    被重载的方法必须改变参数列表(参数个数或类型不一样)；
    被重载的方法可以改变返回类型；
    被重载的方法可以改变访问修饰符；
    被重载的方法可以声明新的或更广的检查异常；
    方法能够在同一个类中或者在一个子类中被重载。
    无法以返回值类型作为重载函数的区分标准。
 */

public class Overloading {
    public static void main(String[] args) {
        Overloading o = new Overloading();
        System.out.println(o.test());

        o.test(1);
        System.out.println(o.test("test3", 3));
        System.out.println(o.test(4,"test4"));
    }

    public int test(){
        System.out.println("test1");
        return 1;
    }

    public void test(int a){
        System.out.println("test2");
    }

    public String test(String s, int a){
        System.out.println("test3");
        return "returntest3";
    }

    public String test(int a, String s){
        System.out.println("test4");
        return "returntest4";
    }
}


