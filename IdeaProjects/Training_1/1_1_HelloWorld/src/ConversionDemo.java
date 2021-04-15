public class ConversionDemo {
    public static void main(String[] args) {
        // 定义两个int类型的变量
        int a = 20;
        int b = 30;
        System.out.println(a + b);

        // 可以把结果接收
        int c = a + b;
        System.out.println(c);
        System.out.println("-----------------------");

        // 定义一个int类型，和一个byte类型变量
        int aa = 10;
        byte bb = 20;
        System.out.println(aa + bb);

        int cc = aa + bb;
        System.out.println(cc);
        // byte cc = aa + bb 会报错
        // byte类型和int类型计算，会先讲byte类型提升为int类型进行计算

        // 如果硬要用byte类型接收，可以通过强制转换类型实现
        byte dd = (byte) (aa + bb); //aa + bb的结果是一个int类型，然后强制将其转换为byte类型
        System.out.println(dd);

        //  强制转换可能丢失精度
        double d1 = 3.14;
        int a1 = (int)d1;
        System.out.println(a1);
    }
}
