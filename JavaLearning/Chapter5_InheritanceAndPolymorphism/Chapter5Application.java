/**
 * 第5章 综合应用 - 员工管理系统
 * 知识点：综合运用继承、多态、super、instanceof等
 */

public class Employee {
    protected String empId;
    protected String name;
    protected double baseSalary;
    //构造方法
    public Employee(String empId, String name, double baseSalary) {
        this.empId = empId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // 计算薪资 - 父类提供基础实现
    public double calculateSalary() {
        return baseSalary;
    }

    public void work() {
        System.out.println(name + "在工作");
    }

    public void displayInfo() {
        System.out.println("员工ID: " + empId + ", 姓名: " + name +
                         ", 基本薪资: " + baseSalary);
    }
}

// 全职员工
class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(String empId, String name, double baseSalary, double bonus) {
        super(empId, name, baseSalary);//调用父类
        this.bonus = bonus;
    }

    // 重写计算薪资方法
    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }

    @Override
    public void work() {
        System.out.println(name + "全职员工在办公室工作");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("奖金: " + bonus);
        System.out.println("总薪资: " + calculateSalary());
    }
}

// 兼职员工
class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String empId, String name, double hourlyRate, int hoursWorked) {
        super(empId, name, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public void work() {
        System.out.println(name + "兼职员工工作了" + hoursWorked + "小时");
    }

    @Override
    public void displayInfo() {
        System.out.println("员工ID: " + empId + ", 姓名: " + name);
        System.out.println("小时费率: " + hourlyRate + ", 工作小时数: " + hoursWorked);
        System.out.println("总薪资: " + calculateSalary());
    }
}

// 管理者
class Manager extends FullTimeEmployee {
    private double managementBonus;

    public Manager(String empId, String name, double baseSalary,
                   double bonus, double managementBonus) {
        super(empId, name, baseSalary, bonus);
        this.managementBonus = managementBonus;
    }

    @Override
    //加上奖金之后的工资计算法
    public double calculateSalary() {
        return super.calculateSalary() + managementBonus;
    }

    @Override
    public void work() {
        System.out.println(name + "经理在管理员工");
    }

    public void conductMeeting() {
        System.out.println(name + "在召开会议");
    }
}

// 人力资源管理系统
class HRSystem {
    public void processPayroll(Employee[] employees) {
        System.out.println("\n========== 工资处理系统 ==========");
        double totalPayroll = 0;

        for (Employee emp : employees) {//从employee数组里面一个一个拿出来，每次叫emp
            double salary = emp.calculateSalary();
            System.out.println(emp.name + ": " + salary);
            totalPayroll += salary;//要发的总工资

            // 多态应用：根据实际类型执行不同操作
            if (emp instanceof Manager) {
                ((Manager) emp).conductMeeting();
            } else {
                emp.work();
            }
        }

        System.out.println("总工资: " + totalPayroll);
    }

    public void displayEmployeeDetails(Employee[] employees) {
        System.out.println("\n========== 员工详细信息 ==========");
        for (Employee emp : employees) {
            emp.displayInfo();
            System.out.println();
        }
    }
}

// 测试类
class Chapter5Application {
    public static void main(String[] args) {
        // 创建不同类型的员工
        Employee fullTime = new FullTimeEmployee("FT001", "张三", 5000, 1000);
        Employee partTime = new PartTimeEmployee("PT001", "李四", 50, 160);
        Employee manager = new Manager("MG001", "王五", 8000, 2000, 3000);

        // 创建员工数组（父类引用指向子类对象 - 多态）
        Employee[] employees = {fullTime, partTime, manager};

        // 使用HR系统
        HRSystem hrSystem = new HRSystem();
        hrSystem.displayEmployeeDetails(employees);
        hrSystem.processPayroll(employees);
    }
}
