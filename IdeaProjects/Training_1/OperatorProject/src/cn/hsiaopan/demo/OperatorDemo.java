package cn.hsiaopan.demo;

public class OperatorDemo {
    public static void main(String[] args) {
        /*
           字符的加法运算
           定义两个变量 int，char
         */
        int a = 10;
        char ch = 'a';
        System.out.println(a + ch); //107

        /*
           字符串的假发运算
         */
        System.out.println("hello" + "world");
        System.out.println("hello" + 10); // hello10
        System.out.println("hello" + 10 + 20); // hello1020
        System.out.println(10 + 20 + "hello"); // 30hello

        /*
           ++自增
         */
        int b = a++;
        System.out.println("a:" + a);
        System.out.println("b:" + b);

        /*
           赋值运算
         */
        int c = 10;
        System.out.println("c:" + c);
        System.out.println("-----------------");

        c += 20;
        System.out.println("c:" + c);
        System.out.println("-----------------");

        short s = 2;
        // s = s + 1 会报错
        s += 1;  // s = (short) (s + 1) 强制类型转换，不建议
        System.out.println(s);
        System.out.println("-------------------");

        /*
          关系运算符
          定义三个变量
         */
        int i = 10;
        int j = 20;
        int k = 10;

        System.out.println(i == j);
        System.out.println(i == k);
        System.out.println("-------------------");

        System.out.println(i != j);
        System.out.println(i != k);
        System.out.println("-------------------");

        System.out.println(i > j);
        System.out.println(i > k);
        System.out.println("-------------------");

        System.out.println(i >= j);
        System.out.println(i >= k);
        System.out.println("-------------------");

        System.out.println(i == j);
        System.out.println(i = j);
        System.out.println("-------------------");

        /*
           逻辑运算符
           && 逻辑与，并且
           || 逻辑或，或者
           !  逻辑非，不是
         */
        System.out.println(true && true);  //true
        System.out.println(true && false); //false
        System.out.println(false && true); //false
        System.out.println(false && false);//false
        System.out.println("-------------------");

        System.out.println(true || true);  //true
        System.out.println(true || false); //true
        System.out.println(false || true); //true
        System.out.println(false || false);//false
        System.out.println("-------------------");

        System.out.println(!true); //false
        System.out.println(!false);//true
        System.out.println("-------------------");

        System.out.println(!!!!!true); //5个！ ，奇数个，false

    }
}
