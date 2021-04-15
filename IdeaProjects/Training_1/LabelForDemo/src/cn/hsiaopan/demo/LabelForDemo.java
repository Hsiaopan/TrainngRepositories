package cn.hsiaopan.demo;

public class LabelForDemo {
    public static void main(String[] args) {
        /*
            需求：查找第二个班的第5个同学，
         */
        // 通过for获取每个班级
        LabelClass:for (int i = 1; i < 4; i++) {
            // 在班级循环中，再次通过for循环获取每个学生的信息
            LabelStudent:for (int j = 1; j < 11; j++) {
                // 打印当前学生的信息
                System.out.println("正在查找第" + i + "个班级的第" + j + "个学生");
                // 判断当前学生是否是程序员同学（第二个班级的第五个）
                if(i == 2 && j == 5){
                    System.out.println("找到了程序猿同学！");
                    break LabelClass;
                }
            }
            System.out.println();

        }
    }
}
