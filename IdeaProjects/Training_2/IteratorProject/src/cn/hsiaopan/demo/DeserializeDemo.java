package cn.hsiaopan.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeDemo {
    public static void main(String[] args) {
        SerializableDemo.Employee employee;
        try {
            FileInputStream fileInputStream = new FileInputStream("/tmp/employee.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            employee = (SerializableDemo.Employee) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

        }catch (IOException i){
            i.printStackTrace();
            return;
        }catch (ClassNotFoundException c){
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + employee.name);
        System.out.println("Address: " + employee.address);
        System.out.println("SSN: " + employee.SSN); // 0 该属性是短暂的，该值没有被发送到输出流，反序列化对象后为0
        System.out.println("Number: " + employee.number);
    }
}
