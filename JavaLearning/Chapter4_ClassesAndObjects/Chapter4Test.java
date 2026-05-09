/**
 * 第4章 - 测试和演示
 * 演示如何创建对象、使用属性和方法、this和static关键字
 */

public class Chapter4Test {
    public static void main(String[] args) {
        System.out.println("========== 第4章 类和对象 ==========\n");

        // 1. 演示基本类的创建和使用
        System.out.println("--- 演示1：基本类的创建和使用 ---");
        BasicClass emp = new BasicClass();
        emp.setName("张三");
        emp.setAge(28);
        emp.setSalary(5000);
        emp.displayInfo();
        double bonus = emp.calculateBonus(0.2);
        System.out.println("年终奖: " + bonus + "\n");

        // 2. 演示对象创建和不同构造方法
        System.out.println("--- 演示2：对象创建（无参/有参构造）---");
        ObjectCreation car1 = new ObjectCreation();
        System.out.println("car1创建完成");

        ObjectCreation car2 = new ObjectCreation("BMW", "红色", 300000);
        car2.start();
        car2.displayDetails();
        car2.stop();
        System.out.println();

        // 3. 演示this和static关键字
        System.out.println("--- 演示3：this和static关键字 ---");
        ThisAndStaticDemo obj1 = new ThisAndStaticDemo("对象1", 1);
        ThisAndStaticDemo obj2 = new ThisAndStaticDemo("对象2", 2);
        ThisAndStaticDemo obj3 = new ThisAndStaticDemo("对象3", 3);

        obj1.displayInfo();
        System.out.println();
        ThisAndStaticDemo.displayStaticInfo();
        System.out.println();

        // 4. 演示综合应用 - 学生管理系统
        System.out.println("--- 演示4：综合应用 - 学生管理系统 ---");
        Student.setSchool("浙江大学计算机学院");

        Student stu1 = new Student("S001", "李明", 20, 3.8);
        Student stu2 = new Student("S002", "王丽", 20, 3.5);
        Student stu3 = new Student("张华", 19);  // 使用重载构造方法

        stu1.displayInfo();
        System.out.println();
        stu2.displayInfo();
        System.out.println();
        stu3.displayInfo();
        System.out.println();

        Student.displayClassInfo();
    }
}
