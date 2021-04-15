package cn.hsiaopan.demo;

public class OverLoadDemo {
    public static void main(String[] args) {
        /*
            方法重载
         */

        int a1 = 10;
        int b1 = 20;
        boolean c1 = compare(a1, b1);
        System.out.println(c1);

        long a2 = 10L;
        long b2 = 20L;
        boolean c2 = compare(a2, b2);
        System.out.println(c2);

        double a3 = 10D;
        double b3 = 20D;
        boolean c3 = compare(a3, b3);
        System.out.println(c3);

    }

    public static boolean compare(int a, int b){
        return a == b;
    }

    public static boolean compare(long a, long b){
        return a == b;
    }

    public static boolean compare(double a, double b){
        return a == b;
    }
}
