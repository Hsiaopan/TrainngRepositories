package cn.hsiaopan.demo2;

public class Test {
    public static void main(String[] args) {
        Animal a = new Animal("憨批",1, "母");
        System.out.println(a.getName());

        Dog dog = new Dog();
        dog.setName("二狗");
        dog.setAge(4);
        dog.setSex("母");
        dog.watch();

        System.out.println(dog.getName());
        System.out.println(dog.getAge());
        System.out.println(dog.getSex());

        Pig pig = new Pig();
        pig.eat();
        pig.snore();

    }
}
