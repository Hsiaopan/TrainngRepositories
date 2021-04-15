package cn.hsiaopan.demo;

public class VirtualDemo {
    public static void main(String[] args) {
        Salary s = new Salary("员工 A","北京", 3, 4800);
        Employee e = new Salary("员工 B", "上海",2, 4500);
        //System.out.println("使用 Salary 的引用调用 mailCheck -- ");
        s.mailCheck();
        //System.out.println("\n使用 Employee 的引用调用 mailCheck --");
        e.mailCheck();
    }
}
