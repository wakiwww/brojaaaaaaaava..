/**
 * 第5章 - 5.5 final关键字
 *
 * 【核心概念】final = "最终的、不可改变的"
 *   可以修饰三种东西：类、方法、变量
 *
 * 【final 类】不能被继承
 *   比如 String 类就是 final 的，你不能写 class MyString extends String
 *   目的：防止别人修改这个类的核心行为
 *
 * 【final 方法】不能被子类重写（@Override）
 *   目的：保护关键方法不被子类篡改
 *
 * 【final 变量】值一旦设定就不能修改（常量）
 *   - 基本类型（int、double）：值不能改
 *   - 引用类型（对象）：引用不能改（指向另一个对象），但对象内部的属性可以改
 *   - 命名习惯：全大写 + 下划线，如 MAX_SIZE、PI
 */

// ========== final 类 ==========
// 不能被继承，不能写 class Xxx extends ImmutableData
final class ImmutableData {

    // final 变量：必须在定义时 或 构造方法中 初始化，之后不能再改
    private final String id;
    private final int value;
    private final long createdTime;

    public ImmutableData(String id, int value) {
        // final 变量在构造方法里初始化 —— 这是允许的（因为是第一次赋值）
        this.id = id;
        this.value = value;
        this.createdTime = System.currentTimeMillis();
        // 之后如果再写 this.id = "xxx"，编译报错！final 变量只能赋值一次
    }

    // final 方法：子类（如果有的话）不能重写这些方法
    // 但 ImmutableData 是 final 类，根本不会有子类，所以这里 final 是双重保护
    public final String getId() { return id; }
    public final int getValue() { return value; }
    public final long getCreatedTime() { return createdTime; }
}

// ========== 非 final 类：可以被继承 ==========
class Parent {

    // 【static final】类级别的常量，全大写命名
    // 所有对象共享，值不可变
    public static final double PI = 3.14159;
    public static final int MAX_SIZE = 100;

    // final 方法 —— 子类不能重写
    public final void criticalOperation() {
        System.out.println("这是一个关键操作，不能被修改");
    }

    // 普通方法 —— 子类可以重写
    public void normalOperation() {
        System.out.println("这是一个普通操作，可以被重写");
    }
}

// ========== 子类继承 Parent ==========
class Child extends Parent {

    // 可以重写普通方法
    @Override
    public void normalOperation() {
        System.out.println("子类重写了普通操作");
    }

    // 不能重写 final 方法！下面的代码会编译报错：
    // @Override
    // public void criticalOperation() { }  // ❌ 编译错误

    // 访问父类的 static final 常量
    public void showConstants() {
        // 用类名访问，因为是 static 的
        System.out.println("PI值: " + Parent.PI);
        System.out.println("最大大小: " + Parent.MAX_SIZE);
    }
}

// ========== 演示 ==========
class FinalDemo {
    public static void main(String[] args) {
        System.out.println("========== final关键字演示 ==========\n");

        // 1. final 局部变量
        final int x = 10;
        System.out.println("final变量x: " + x);
        // x = 20;  // ❌ 编译错误：final 变量不能修改

        // 2. final 类的实例
        ImmutableData data = new ImmutableData("D001", 100);
        System.out.println("不可变数据ID: " + data.getId());
        System.out.println("不可变数据值: " + data.getValue());

        // 3. final 方法 vs 普通方法
        Parent parent = new Parent();
        parent.criticalOperation();  // 调用 final 方法
        parent.normalOperation();    // 调用普通方法

        Child child = new Child();
        child.criticalOperation();   // 继承了父类的 final 方法，不能改但能用
        child.normalOperation();     // 调用子类重写的版本

        // 4. static final 常量
        child.showConstants();
    }
}
