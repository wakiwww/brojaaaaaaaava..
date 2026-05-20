/**
 * 练习题 - static 关键字练习
 *
 * 要求：
 *   1. 创建一个 Student 类，包含以下属性：
 *      - 姓名（name）           → 实例变量
 *      - 学号（id）             → 实例变量
 *      - 班级名称（className）   → 静态变量（所有学生同班）
 *      - 学生总数（totalCount）  → 静态变量
 *
 *   2. 提供构造方法：传入姓名和学号，每创建一个学生 totalCount++
 *
 *   3. 提供以下方法：
 *      - displayInfo()          → 实例方法，打印学生信息
 *      - static setClassName()  → 静态方法，设置班级名称
 *      - static getTotalCount() → 静态方法，返回学生总数
 *
 *   4. 在 main 方法中：
 *      - 用类名调用 setClassName("Java一班")
 *      - 创建 3 个学生对象
 *      - 用类名调用 getTotalCount() 打印总人数
 *      - 遍历每个学生调用 displayInfo()
 *
 * 【知识点】
 *   - static 变量：所有对象共享（className、totalCount）
 *   - 实例变量：每个对象各有一份（name、id）
 *   - static 方法：用类名直接调用，不需要创建对象
 *   - 实例方法：必须通过对象调用
 */

public class Practice_03 {

    // ========== 实例变量 ==========
    private String name;
    private int id;

    // ========== 静态变量（所有学生共享）==========
    private static String className = "未分班";
    private static int totalCount = 0;

    // ========== 构造方法 ==========
    public Practice_03(String name, int id) {
        this.name = name;
        this.id = id;
        totalCount++;  // 每创建一个学生，总数 +1
    }

    // ========== 实例方法 ==========
    public void displayInfo() {
        System.out.println("学号: " + id + ", 姓名: " + name + ", 班级: " + className);
    }

    // ========== 静态方法 ==========
    public static void setClassName(String className) {
        // 注意：这里 className 是局部参数，要赋值给静态变量需要加类名
        Practice_03.className = className;
    }

    public static int getTotalCount() {
        return totalCount;
    }

    // ========== 主方法 ==========
    public static void main(String[] args) {

        // 1. 用类名直接调用静态方法（不需要 new）
        Practice_03.setClassName("Java一班");

        // 2. 创建 3 个学生
        Practice_03 s1 = new Practice_03("张三", 1001);
        Practice_03 s2 = new Practice_03("李四", 1002);
        Practice_03 s3 = new Practice_03("王五", 1003);

        // 3. 用类名调用静态方法获取总人数
        System.out.println("学生总数: " + Practice_03.getTotalCount());  // 输出 3

        System.out.println("----------");
        
        // 4. 用对象调用实例方法
        s1.displayInfo();
        s2.displayInfo();
        s3.displayInfo();

        // 【思考】
        // - 为什么 setClassName 用类名调用，而 displayInfo 用对象调用？
        //
        // - 如果改了 className，3个学生的班级会一起变吗？
        // - static 方法里能写 this.name 吗？为什么？
    }
}
