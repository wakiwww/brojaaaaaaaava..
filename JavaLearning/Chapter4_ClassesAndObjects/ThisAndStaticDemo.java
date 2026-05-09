/**
 * 第4章 - 4.5 this关键字 和 4.6 static关键字
 *
 * 【this 关键字】指向当前对象（谁调用方法，this 就是谁）
 *   用法1：this.属性 → 区分同名的参数和属性
 *   用法2：this.方法() → 在一个方法里调用另一个方法（可省略）
 *   用法3：this(...)   → 在构造方法里调用另一个构造方法
 *
 * 【static 关键字】表示"属于类，不属于对象"
 *   - static 变量：所有对象共享同一份（类比：班级的总人数，所有人看到的都是同一个数字）
 *   - 非 static 变量：每个对象各有一份（类比：每个人自己的名字）
 *   - static 方法：只能访问 static 变量，不能访问 this（因为没有具体对象）
 *
 * 【对比】
 *   非 static：对象.属性 / 对象.方法()  → 必须先创建对象
 *   static：  类名.属性 / 类名.方法()   → 不需要创建对象，直接用类名调用
 */

public class ThisAndStaticDemo {

    // ========== 实例变量（属于对象）==========
    // 每个对象各有一份，互不影响
    // 用法：对象.name
    private String name;
    private int id;

    // ========== 类变量（属于类，被所有对象共享）==========
    // 所有对象共用同一份，任何对象修改都会影响其他人
    // 用法：ThisAndStaticDemo.totalCount
    private static int totalCount = 0;
    private static double commonRate = 0.1;

    // ========== 构造方法 ==========
    public ThisAndStaticDemo(String name, int id) {
        // 【this 用法1】区分同名变量
        // this.name = 对象的属性，name = 传入的参数
        this.name = name;
        this.id = id;

        // 【static 变量的特点】每创建一个对象，totalCount 就 +1
        // 因为 totalCount 是 static，所有对象共享，所以能统计"一共创建了多少个对象"
        totalCount++;
    }

    // ========== 实例方法 ==========
    // 可以访问实例变量（this.name）和类变量（totalCount）
    public void displayInfo() {
        // this 可以省略，但写上更清晰
        System.out.println("对象名: " + this.name + ", ID: " + this.id);
        // 用类名访问 static 变量（推荐写法，明确表示这是类变量）
        System.out.println("总对象数: " + ThisAndStaticDemo.totalCount);
    }

    // ========== 静态方法 ==========
    // 只能访问 static 变量，不能访问实例变量
    public static void displayStaticInfo() {
        System.out.println("===静态信息===");
        System.out.println("总创建对象数: " + totalCount);   // OK，totalCount 是 static
        System.out.println("公共费率: " + commonRate);        // OK，commonRate 是 static
        // System.out.println(this.name);  // ❌ 编译错误！static 方法没有 this
        // 因为 static 方法属于类，不属于任何对象，所以没有 this
    }

    // ========== 实例方法调用另一个实例方法 ==========
    public void callOtherMethod() {
        // this.displayInfo() 等价于 displayInfo()
        // 这里的 this 指代调用 callOtherMethod() 的那个对象
        this.displayInfo();
    }

    // ========== Getter / Setter ==========
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    // static 方法：用类名直接调用，不需要创建对象
    // ThisAndStaticDemo.getTotalCount()
    public static int getTotalCount() {
        return totalCount;
    }
}
