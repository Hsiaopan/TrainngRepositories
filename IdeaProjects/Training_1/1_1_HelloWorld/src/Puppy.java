public class Puppy{
    int puppyAge;
    public Puppy(String name){
        //
        System.out.println("这个狗子的名字是：" + name);
    }

    public void setAge(int age){
        puppyAge = age;
    }

    public int getAge(){
        System.out.println("狗子的年龄为：" + puppyAge);
        return puppyAge;
    }

    public static void main(String[] args){
        // 创建对象
        Puppy myPuppy = new Puppy("二狗子");

        // 通过方法来设定age
        myPuppy.setAge(4);

        // 调用另一个方法获取age
        myPuppy.getAge();

        // 其他方式访问变量
        System.out.println("变量值：" + myPuppy.puppyAge);
    }

}
