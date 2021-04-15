package cn.hsiaopan.demo;

public class ForForDemo {
    public static void main(String[] args) {
        // 需求 按照班级获取所有班级的同学（假设有3个班级，每个班级5名学生）
        for(int i = 1; i <= 3; i++){
            for(int j = 1; j <= 5; j++){
                System.out.println("正在获取第" + i + "班级的第" + j + "个学生...");
            }
            System.out.println("第" + i + "个班级的学生已经获取完成...");
        }
    }
}
