package cn.hsiaopan.demo;

public class Test {
    public static void main(String[] args) {
        // 调用values()
        Color[] arr = Color.values();
        System.out.println(toString(arr));

        for (Color col : arr) {
            System.out.println(col.getColor() + " at index " + col.ordinal());
        }

        System.out.println(Color.valueOf("RED"));
    }

    public static String toString(Object[] a) {

        StringBuilder b = new StringBuilder();
        for (int i = 0;; i++) {
            b.append((a[i]));
            if(i == a.length - 1)
                return b.toString();
            b.append(", ");
        }

    }

}
