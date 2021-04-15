package cn.hsiaopan.demo;

/*
    enum 定义的枚举默认继承了 java.lang.Enum 类，并实现了 java.lang.Seriablizable 和 java.lang.Comparable两个接口
    values(), ordinal() 和 valueOf() 方法位于 java.lang.Enum 类中:
        values() 返回枚举中的所有值
        ordinal() 方法可以找到每个枚举常量的索引，就像数组索引一样
        valueOf() 方法返回指定字符串值的枚举常量
 */

public class SwitchMyClass {
    public static void main(String[] args) {
        Color myVar = Color.BLUE;

        switch (myVar) {
            case RED -> System.out.println("红色");
            case GREEN -> System.out.println("绿色");
            case BLUE -> System.out.println("蓝色");
        }
    }
}
