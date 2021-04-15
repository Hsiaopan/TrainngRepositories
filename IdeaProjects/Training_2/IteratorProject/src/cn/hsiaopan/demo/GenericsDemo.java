package cn.hsiaopan.demo;

/*
    所有泛型方法声明都有一个类型参数声明部分（由尖括号分割），该类型参数声明部分在方法返回类型之前
    没一个类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也称为一个类型变量，用于指定一个泛型类型名称的标识符
    类型参数能被用来声明返回值类型，并能作为泛型方法得到的时机参数类型的占位符
    泛型方法体的声明和其他方法一样，注意类型参数只能代表引用型类型，不是原始类型
 */

public class GenericsDemo {
    public static void main(String[] args) {
        // 创建不同类型数组
        Integer[] integers = {3, 5, 1, 7, 9, 6};
        Double[] doubles = {5.2, 3.5, 6.7, 2.7};
        Character[] characters = {'H', 'J', 'E', 'M', 'B'};

        System.out.println("整型数组元素：");
        printArray(integers);

        System.out.println("\n双精度型数组元素为：");
        printArray(doubles);

        System.out.println("\n字符型数组元素为：");
        printArray(characters);
    }

    public static <E> void printArray(E[] inputArray) {
        for (E element :
                inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
}
