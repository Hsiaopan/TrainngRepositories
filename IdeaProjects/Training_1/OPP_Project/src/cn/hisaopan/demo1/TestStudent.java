package cn.hisaopan.demo1;

public class TestStudent {
    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.setName("张三");
        stu1.setAge(18);

        System.out.println(stu1.getName());
        System.out.println(stu1.getAge());

        Student stu2 = new Student("李四", 28);
        System.out.println(stu2.getName());
        System.out.println(stu2.getAge());
    }
}
