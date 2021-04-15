package cn.hsiaopan.demo;

/*
    抽象类 不能被实例化，只有抽象类的非抽象子类才可以创建对象。
    抽象类不一定包含抽象方法，但是有抽象方法必定是抽象类
    抽象类中的抽象方法只是声明，不包含方法体
    构造方法，类方法不能声明为抽象方法
    抽象类的子类必须给出抽象类中的抽象方法的具体实现，除非该子类也是抽象类。
 */
public abstract class Employee {
    private String name;
    private String address;
    private int number;

    // 构造方法
    public Employee(String name, String address, int number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public abstract double computePay();

    public void mailCheck(){
        System.out.println("Mailing to check to " + this.name
        + " " + this.address);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", number=" + number +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
