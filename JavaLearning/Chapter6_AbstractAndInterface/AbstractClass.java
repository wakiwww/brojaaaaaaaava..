/**
 * 第6章 - 6.1 抽象类
 *
 * 【核心概念】抽象类 = 不能直接创建对象的类，只能被继承
 *   语法：abstract class 类名 { }
 *   类比：抽象类就像"设计图纸"，你不能住进图纸里，但可以按图纸盖房子
 *
 * 【抽象方法】
 *   - 用 abstract 修饰，只有方法签名，没有方法体（没有 {}）
 *   - 子类必须实现（重写）所有抽象方法，否则子类也必须声明为 abstract
 *   - 类比：图纸上标注"这里要装窗户"，但没说具体装什么窗户，盖房子的人自己决定
 *
 * 【抽象类 vs 普通类】
 *   - 抽象类可以有抽象方法（没有实现），普通类不行
 *   - 抽象类不能 new，普通类可以
 *   - 抽象类可以有构造方法（给子类调用）、普通方法、属性 —— 和普通类一样
 *
 * 【什么时候用抽象类】
 *   当多个类有共同特征，但某些行为"每个子类都不一样"时
 *   比如：圆形、矩形都是"形状"，都有面积，但计算公式不同
 */

// ========== 抽象类：形状 ==========
// abstract 表示这个类是抽象的，不能写 new Shape(...)
abstract class Shape {
    protected String name;
    protected String color;

    // 抽象类可以有构造方法 —— 虽然自己不能 new，但子类创建对象时会调用它
    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }

    // 【抽象方法】只有声明，没有实现
    // 子类必须提供具体的计算方式，否则编译报错
    abstract public double getArea();      // 面积怎么算？子类决定
    abstract public double getPerimeter(); // 周长怎么算？子类决定

    // 普通方法 —— 子类可以直接继承，也可以重写
    public void displayInfo() {
        System.out.println("形状: " + name + ", 颜色: " + color);
    }

    public void draw() {
        System.out.println("绘制" + name);
    }
}

// ========== 具体类：圆形（实现抽象类）==========
// extends Shape → 继承了 name、color、displayInfo()、draw()
// 必须实现 Shape 的两个抽象方法：getArea() 和 getPerimeter()
class Circle extends Shape {
    private double radius;

    public Circle(String name, String color, double radius) {
        super(name, color);  // 调用父类构造方法
        this.radius = radius;
    }

    // 【实现抽象方法】用 @Override 标记，告诉编译器这是在实现父类的抽象方法
    @Override
    public double getArea() {
        return Math.PI * radius * radius;  // 圆的面积公式
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;  // 圆的周长公式
    }

    // 重写普通方法 —— 在父类版本基础上补充信息
    @Override
    public void displayInfo() {
        super.displayInfo();  // 先调用父类的 displayInfo
        System.out.println("半径: " + radius);
        System.out.println("面积: " + getArea());
        System.out.println("周长: " + getPerimeter());
    }
}

// ========== 具体类：矩形 ==========
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String name, String color, double width, double height) {
        super(name, color);
        this.width = width;
        this.height = height;
    }

    // 矩形的面积和周长公式和圆形不同 —— 这就是多态的体现
    @Override
    public double getArea() {
        return width * height;  // 矩形面积公式
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);  // 矩形周长公式
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("宽: " + width + ", 高: " + height);
        System.out.println("面积: " + getArea());
        System.out.println("周长: " + getPerimeter());
    }
}

// ========== 演示 ==========
class AbstractClassDemo {
    public static void main(String[] args) {
        System.out.println("========== 抽象类演示 ==========\n");

        // Shape shape = new Shape("形状", "黑色");  // ❌ 编译错误！抽象类不能 new

        // 用子类创建对象 —— 父类引用指向子类对象（多态）
        Shape circle = new Circle("圆形", "红色", 5);
        Shape rectangle = new Rectangle("矩形", "蓝色", 4, 6);

        circle.displayInfo();
        System.out.println();
        rectangle.displayInfo();

        // 【多态应用】用父类类型的数组存储不同子类对象
        // 统一调用 getArea()，每个对象执行自己的计算公式
        System.out.println();
        Shape[] shapes = {circle, rectangle};
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();  // 圆用圆的公式，矩形用矩形的公式
        }
        System.out.println("总面积: " + totalArea);
    }
}
