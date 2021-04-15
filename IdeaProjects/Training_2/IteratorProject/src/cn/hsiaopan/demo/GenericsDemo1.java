package cn.hsiaopan.demo;

public class GenericsDemo1 {
    public static void main(String[] args) {
        System.out.printf("%d, %d 和 %d 中最大的数为 %d\n\n",
                3, 5, 8, maximum(3, 5, 8));

        System.out.printf("%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n",
                5.7, 8.9, 3.8, maximum(5.7, 8.9, 3.8));

        System.out.printf("%s, %s 和 %s 中最大的数为 %s\n",
                "apple", "orange", "pear", maximum("apple", "orange", "pear"));
    }

    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }
}
