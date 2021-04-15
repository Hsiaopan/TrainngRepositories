package cn.hsiaopan.demo;

public class ContinueDemo {
    public static void main(String[] args) {
        // 需求 每逢7必跳过
        // 100以内

        //
        for(int i = 1; i <= 100; i++){
            if(i % 10 == 7 || i/10 % 10 == 7 || i % 7 == 0){
                System.out.println("...");
                continue; // 包含7跳过
            }
            System.out.println(i);
        }

    }
}
