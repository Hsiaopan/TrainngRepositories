package cn.hsiaopan.demo;

public class ArrayDemo6 {
    public static void main(String[] args) {
        // 排序并打印
        int[] arr = {2,4,3,7,9,15,23,7,5,3,2,7};

        // sortArray
        sortArray(arr);

        // printArray
        ArrayDemo5.printArray(arr);

    }

    public static void sortArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]){
                    swap(array, j, j + 1);
                }

            }

        }
    }

    public static void swap(int[] array, int a, int b){
        int c = array[a];
        array[a] = array[b];
        array[b] = c;
    }
}
