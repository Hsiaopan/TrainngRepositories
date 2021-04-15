package cn.hsiaopan.demo;

public class ForMyClass {
    public static void main(String[] args) {
        for(Color myVar: Color.values()){
            System.out.println(myVar.getColor());
        }
    }
}
