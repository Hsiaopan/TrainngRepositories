package cn.hsiaopan.demo;

public class DoWhileDemo1 {
    public static void main(String[] args) {
        // 学完一个知识，至少练习1次，3次为学会

        int count = 1;
        boolean isOK = false;

        do{
            System.out.println("正在进行第" + count + "次学习...");
            if(count >= 3){
                isOK = true;
            }
            count++;
        }while (!isOK);
    }
}
