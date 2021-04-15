package cn.hsiaopan.demo;

import java.util.Scanner;

public class IfDemo5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("录入学生成绩：");
        int score = sc.nextInt();

        if(score >= 90 && score <= 100){
            System.out.println("皇帝");
        }else if(score >= 80 && score < 90){
            System.out.println("宰相");
        }else if(score >= 70 && score < 80){
            System.out.println("大臣");
        }else if(score >= 60 && score < 70){
            System.out.println("县官");
        }else if(score >= 0 && score < 60){
            System.out.println("草民");
        }else{
            System.out.println("请输入一个正确的成绩！");
        }

    }
}
