package cn.hsiaopan.demo;


public class ForComposeDemo {
    public static void main(String[] args) {
        // 假设有3个班级，每个班级有35个同学， 现在要将100个橙子分发给各个同学

        int count = 0;

        LabelClass:for(int i = 1; i < 4; i++) {
            LabelStudent:for (int j = 1; j < 36; j++) {

                if(j % 5 == 0){
                    System.out.println("该同学已经有了！不需要发放！");
                    continue;
                }
                System.out.println("正在给第" + i + "个班级的第" + j + "个学生发送...");
                count++;

                if(count >= 100){
                    break LabelClass;
                }

            }
            System.out.println("第" + i + "个班级已经发放完毕");
            System.out.println();
        }
        System.out.println("各班级都已发送完毕，总共发放" + count + "个橙子");


    }
}
