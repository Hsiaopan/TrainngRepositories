package cn.hsiaopan.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
    一个类的对象想要序列化成功，必须满足两个条件：
        该类必须实现java.io.Serializable 接口
        该类的所有属性必须是可序列化的。如果有一个属性不是可序列化的，则该属性必须注明是短暂的


 */
public class SerializableDemo {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.name = "Ryan Ali";
        employee.address = "Pekka Kan, Ambient Peer";
        employee.SSN = 111112234;
        employee.number = 105;

        /*
            ObjectOutputStream 类用来序列化一个对象，如下实例化一个Employee 对象，并将该对象序列化到一个文件中。
            该程序执行后，就创建一个名为 employee.ser 文件。
         */
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("/tmp/employee.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employee);
            objectOutputStream.close();
            fileOutputStream.close();

            System.out.println("Serialized data is saved in /tmp/employee.ser");
        }catch (IOException i){
            i.printStackTrace();
        }

    }

    public static class Employee implements java.io.Serializable{
        public String name;
        public String address;
        public transient int SSN;
        public int number;
        public void mailCheck(){
            System.out.println("Mailing a check to " + name + " " + address);
        }
    }
}