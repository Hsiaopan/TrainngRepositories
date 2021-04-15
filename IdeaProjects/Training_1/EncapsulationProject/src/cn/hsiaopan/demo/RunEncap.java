package cn.hsiaopan.demo;

public class RunEncap {
    public static void main(String[] args) {
        EncapTest encap = new EncapTest();
        encap.setName("James");
        encap.setAge(24);
        encap.setIdNum("123456ms");

        System.out.println("Name: " + encap.getName() +
                " Age: " + encap.getAge());
    }
}
