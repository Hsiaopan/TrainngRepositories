public class EmployeeTest {
    public static void main(String[] args) {
        // 使用构造器创建两个对象
        Employee empOne = new Employee("憨批");
        Employee empTwo = new Employee("憨憨");

        // 调用这两个对象的方法
        empOne.empAge(29);
        empOne.empDesignation("高级工程师");
        empOne.empSalary(8000);
        empOne.printEmployee();

        empTwo.empAge(25);
        empTwo.empDesignation("初级工程师");
        empTwo.empSalary(5000);
        empTwo.printEmployee();
    }
}
