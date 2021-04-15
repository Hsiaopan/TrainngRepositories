package cn.hsiaopan.demo;

public interface Hockey extends Sports{
    public void homeGoalScored();
    public void visitingGoalScored();
    public void endOfPeriod(int period);
    public void overtimePeriod(int ot);
}
/*
    Hockey接口自己声明了4个方法，从Sports接口继承了2个方法，这样Hockey接口的类需要实现6个方法。
 */