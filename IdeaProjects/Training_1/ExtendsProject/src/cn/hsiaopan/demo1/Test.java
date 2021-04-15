package cn.hsiaopan.demo1;

public class Test {
    public static void main(String[] args) {
        Child c = new Child();

        c.setName("憨批");
        c.setAge(18);
        System.out.println(c.getName());
        System.out.println(c.getAge());

        // Java中，子类只能继承父类的非私有成员（成员变量，成员方法）
    }
}
