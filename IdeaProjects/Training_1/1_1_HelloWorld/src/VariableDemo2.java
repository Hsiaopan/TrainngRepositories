public class VariableDemo2 {
    public static void main(String[] args) {
        // byte
        byte b = 10;
        System.out.println(b);

        // short
        short s = 20;
        System.out.println(s);

        // int
        int i = 30;
        System.out.println(i);

        // long
        long l = 100000000000L;
        System.out.println(l);

        // float
        float f = 10.3F;
        System.out.println(f);

        // double
        double d = 10.2;
        System.out.println(d);

        // char
        char c = 'a';
        System.out.println(c);

        // boolean
        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1);
        System.out.println(b2);
        System.out.println("---------------------------");

        int a;
        a = 10;
        System.out.println(a);

        {
            int aa = 20;
            System.out.println(aa);
        }

        int bb = 1, cc = 2, dd = 3; // 不建议这么写
        System.out.println(bb+cc+dd);
    }
}
