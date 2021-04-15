package cn.hsiaopan.demo;

public class BreakDemo1 {
    public static void main(String[] args) {
        // 查找班级编号为3的同学，假设班中有15个同学
        for(int i = 1; i <= 15; i++){
            System.out.println("我是编号为 " + i + " 的学生。");

            if(i == 3){ // 编号为3时结束整个循环
                System.out.println("找到编号为 " + i + " 的学生了！");
                break; // 终止循环
            }
        }

    }
}
