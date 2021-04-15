package cn.hsiaopan.demo;

/*
    泛型类的声明和非泛型类的声明类似，除了在类名后面添加类型参数声明部分。
    和泛型方法一样，泛型类的类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。
 */
public class GenericsDemo2<T> {
    private T t;

    public static void main(String[] args) {
        GenericsDemo2<Integer> genericsInteger = new GenericsDemo2<>();
        GenericsDemo2<String> genericsString = new GenericsDemo2<>();

        genericsInteger.add(new Integer(10));
        genericsString.add(new String("Hello World!"));

        System.out.printf("整型值为： %d\n\n", genericsInteger.get());
        System.out.printf("字符串为： %s\n", genericsString.get());
    }

    public T get() {
        return t;
    }

    public void add(T t) {
        this.t = t;
    }

}
