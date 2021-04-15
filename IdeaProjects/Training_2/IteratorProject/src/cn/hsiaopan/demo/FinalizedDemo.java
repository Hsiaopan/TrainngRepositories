package cn.hsiaopan.demo;

import java.util.GregorianCalendar;

public class FinalizedDemo extends GregorianCalendar {
    public static void main(String[] args) {
        try {
            // 创建FinalizedDemo 对象
            FinalizedDemo cal = new FinalizedDemo();

            // 输出当前时间
            System.out.println("" + cal.getTime());

            // finalize cal
            System.out.println("Finalizing...");
            cal.finalize();
            System.out.println("Finalized.");
        }catch (Throwable e){
            e.printStackTrace();
        }
    }
}
