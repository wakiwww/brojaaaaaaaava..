/**
 * 第4章 - 4.3 创建和使用对象
 *
 * 【核心概念】对象创建过程 = new + 构造方法调用
 *   new 类名(参数) → 1. 在内存中分配空间 → 2. 调用构造方法初始化属性
 *
 * 【构造方法】
 *   - 和类名同名，没有返回值（连 void 都没有）
 *   - 创建对象时自动调用，不能手动调用
 *   - 可以有多个（无参、有参），Java 根据你传的参数自动匹配
 *
 * 【this 的三种用法】
 *   1. this.属性 → 区分同名的参数和属性
 *   2. this(...) → 在一个构造方法里调用另一个构造方法
 *   3. this      → 指代当前对象本身
 */

public class ObjectCreation {

    // ========== 属性 ==========
    private String brand;
    private String color;
    private double price;
    private boolean isRunning;

    // ========== 无参构造方法 ==========
    // 创建对象时不传参数：new ObjectCreation()
    // 用默认值初始化所有属性
    //
    // 【知识点】如果不写任何构造方法，Java 会自动提供一个无参构造（所有属性为默认值）
    // 但只要你写了有参构造，Java 就不再自动提供无参构造，需要自己写
    public ObjectCreation() {
        this.brand = "Unknown";
        this.color = "Black";
        this.price = 0.0;
        this.isRunning = false;
    }

    // ========== 有参构造方法 ==========
    // 创建对象时传参数：new ObjectCreation("宝马", "白色", 30.0)
    // 用传入的值初始化属性
    //
    // 【this 的用法1】this.brand = brand
    //   左边 this.brand = 对象的属性
    //   右边 brand = 传进来的参数
    //   如果不加 this，brand = brand 只是参数自己赋给自己，属性没变
    public ObjectCreation(String brand, String color, double price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.isRunning = false;  // isRunning 没有参数名冲突，可以不加 this
    }

    // ========== 行为方法 ==========

    // start() 改变对象的状态
    // 体现了封装：外部不能直接写 car.isRunning = true
    // 必须通过 start()/stop() 方法来控制，方法里可以加逻辑判断
    public void start() {
        if (!isRunning) {       // 只有停止状态才能启动，避免重复启动
            isRunning = true;
            System.out.println(brand + "车已启动");
        }
    }

    public void stop() {
        if (isRunning) {        // 只有运行状态才能停止
            isRunning = false;
            System.out.println(brand + "车已停止");
        }
    }

    public void displayDetails() {
        System.out.println("品牌: " + brand + ", 颜色: " + color +
                         ", 价格: " + price + ", 运行状态: " + (isRunning ? "运行中" : "停止"));
    }

    // ========== Getter / Setter ==========
    // 提供对 private 属性的受控访问
    // getter 命名：get + 属性名首字母大写
    // setter 命名：set + 属性名首字母大写
    // 布尔类型的 getter 习惯用 is 开头（如 isRunning）

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public boolean isRunning() { return isRunning; }
}
