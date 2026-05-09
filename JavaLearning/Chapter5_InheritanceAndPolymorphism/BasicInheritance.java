/**
 * 第5章 - 5.1 继承的概念
 *
 * 【核心概念】继承 = 子类自动拥有父类的属性和方法，然后可以添加自己的东西
 *   语法：public class 子类 extends 父类 {}
 *   类比：孩子继承了父母的基因（属性），然后自己又学了新技能（方法）
 *
 * 【super 关键字】指向父类
 *   用法1：super(参数) → 调用父类的构造方法（必须放在子类构造方法的第一行）
 *   用法2：super.方法() → 调用父类的方法
 *
 * 【访问权限】
 *   - private  → 只有本类能访问，子类看不到
 *   - protected → 本类 + 子类 + 同包能访问（继承场景最常用）
 *   - public   → 所有人都能访问
 *
 * 【@Override 注解】
 *   表示"我在重写父类的同名方法"。加了注解后，如果方法名写错，编译器会报错提醒
 */

// ========== 父类：定义动物的通用特征 ==========
class Animal {

    // protected：子类可以直接访问（对比 private，子类看不到）
    protected String name;
    protected int age;

    // private：只有 Animal 自己能访问，子类（Dog、Bird）不能直接用
    // 如果子类需要读写 type，必须通过 getter/setter
    private String type;

    // 父类的构造方法
    // 子类创建对象时，会先调用父类的构造方法（通过 super(...)）
    public Animal(String name, int age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    // 父类的通用方法 —— 子类可以直接继承使用，也可以 @Override 重写
    public void eat() {
        System.out.println(name + "在吃东西");
    }

    public void sleep() {
        System.out.println(name + "在睡觉");
    }

    public void displayInfo() {
        System.out.println("名字: " + name + ", 年龄: " + age + ", 类型: " + type);
    }

    // getter/setter —— 让子类能间接访问 private 的 type
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}

// ========== 子类 Dog：继承 Animal，添加狗特有的东西 ==========
// extends Animal → Dog 自动拥有 Animal 的 name、age、eat()、sleep() 等
class Dog extends Animal {

    // Dog 自己新增的属性（父类没有 breed）
    private String breed;

    public Dog(String name, int age, String breed) {
        // 【super 用法1】调用父类构造方法
        // 必须放在第一行！先初始化父类的属性，再初始化自己的
        // "犬科"是固定传给父类 type 属性的值
        super(name, age, "犬科");
        this.breed = breed;  // 初始化 Dog 自己的属性
    }

    // 【@Override 重写】子类提供自己的 eat() 实现
    // 调用时，如果对象是 Dog 类型，会执行这个版本而不是父类的
    @Override
    public void eat() {
        System.out.println(name + "狗在吃骨头");
    }

    // Dog 自己新增的方法（父类没有 bark）
    public void bark() {
        System.out.println(name + "在叫: 汪汪汪!");
    }

    // 重写 displayInfo()，先调用父类版本，再补充自己的信息
    @Override
    public void displayInfo() {
        super.displayInfo();  // 【super 用法2】调用父类的 displayInfo()
        System.out.println("品种: " + breed);  // 再加上 Dog 特有的信息
    }

    public String getBreed() { return breed; }
}

// ========== 子类 Bird：继承 Animal，添加鸟特有的东西 ==========
class Bird extends Animal {

    private boolean canFly;

    public Bird(String name, int age, boolean canFly) {
        super(name, age, "鸟类");  // 调用父类构造
        this.canFly = canFly;
    }

    @Override
    public void eat() {
        System.out.println(name + "鸟在啄食");
    }

    // Bird 自己新增的方法
    public void fly() {
        if (canFly) {
            System.out.println(name + "在天空飞翔");
        } else {
            System.out.println(name + "不会飞");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("能否飞行: " + (canFly ? "是" : "否"));
    }
}
