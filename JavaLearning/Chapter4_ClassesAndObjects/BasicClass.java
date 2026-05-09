/**
 * 第4章 - 4.1 & 4.2 基本类定义与面向对象思想
 *
 * 【核心概念】类 = 属性 + 方法
 *   - 属性（成员变量）：描述对象"是什么"（名字、年龄、薪资）
 *   - 方法（成员方法）：描述对象"能做什么"（显示信息、计算奖金）
 *
 * 【封装】属性声明为 private，通过 public 的 getter/setter 控制访问
 *   - 好处：可以在 setter 里加校验，防止外部随意修改
 *   - 类比：你家的东西（private），别人不能直接拿，但可以通过你开的窗口（getter/setter）看或递东西
 */

public class BasicClass {

    // ========== 属性（成员变量）==========
    // private = 只能在本类内部直接访问
    // 外部代码不能写 对象.name，必须通过 getter/setter
    private String name;
    private int age;
    private double salary;

    // ========== Getter：把 private 属性的值"借出去" ==========
    // getter 命名规则：get + 属性名首字母大写
    // 作用：让外部能读取 private 属性的值

    public String getName() {
        return name;  // 返回属性值，外部通过 对象.getName() 来读
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    // ========== Setter：把外部的值"存进来" ==========
    // setter 命名规则：set + 属性名首字母大写
    // 作用：让外部能修改 private 属性的值（可以加校验）
    //
    // 【this 的作用】这里参数名和属性名相同，都是 name
    //   - this.name → 对象自己的属性
    //   - name      → 传进来的参数
    //   如果不加 this，写 name = name，Java 会认为你在把参数赋给自己，属性没变化

    public void setName(String name) {
        this.name = name;  // 把参数的值存到对象的属性里
    }

    public void setAge(int age) {
        // 这里可以加校验逻辑，比如：
        // if (age < 0 || age > 150) { System.out.println("年龄不合理"); return; }
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // ========== 普通方法：定义对象的行为 ==========

    // displayInfo() 读取自己的属性并打印
    // 这里没有用 this.name，因为局部没有同名变量，不会歧义，this 可省略
    public void displayInfo() {
        System.out.println("姓名: " + name + ", 年龄: " + age + ", 薪资: " + salary);
    }

    // calculateBonus() 接收一个参数，返回计算结果
    // 展示了方法的输入（参数）和输出（返回值）
    public double calculateBonus(double rate) {
        return salary * rate;  // 薪资 × 比率 = 奖金
    }
}
