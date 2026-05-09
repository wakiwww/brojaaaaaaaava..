/**
 * 第6章 - 6.2 接口（Interface）
 *
 * 【核心概念】接口 = 一组方法的"规范/契约"
 *   语法：interface 接口名 { void 方法名(); }
 *   类比：接口就像"能力证书"，考到了（implements）就说明你具备这个能力
 *
 * 【接口 vs 抽象类】
 *   - 抽象类：is-a 关系（圆形 IS-A 形状）→ 用 extends
 *   - 接口：  has-a 能力（鸟 HAS-A 飞行能力）→ 用 implements
 *   - 一个类只能继承一个抽象类，但可以实现多个接口
 *
 * 【接口的特点】
 *   - 接口里的方法默认是 public abstract（可以省略不写）
 *   - 类用 implements 实现接口，必须实现接口中所有方法
 *   - 一个类可以同时 implements 多个接口（逗号分隔）
 *
 * 【什么时候用接口】
 *   当你想定义"能力"而不关心"是什么"时
 *   比如：能飞的东西有鸟、飞机、超人，它们没有共同父类，但都有"飞"的能力
 */

// ========== 接口1：可飞行 ==========
// 接口用 interface 关键字，不是 class
// 接口里的方法没有方法体（{}），只有声明
interface Flyable {
    void fly();   // 默认 public abstract
    void land();
}

// ========== 接口2：可游泳 ==========
interface Swimmable {
    void swim();
    void dive();
}

// ========== 接口3：可走路 ==========
interface Walkable {
    void walk();
    void stop();
}

// ========== 实现类1：鸟（只实现一个接口）==========
// implements Flyable → 鸟"拥有飞行能力"
// 必须实现 Flyable 接口中的所有方法：fly() 和 land()
class Bird implements Flyable {
    private String name;

    public Bird(String name) {
        this.name = name;
    }

    @Override
    public void fly() {
        System.out.println(name + "在天空中飞翔");
    }

    @Override
    public void land() {
        System.out.println(name + "降落在地面上");
    }
}

// ========== 实现类2：鸭子（实现多个接口）==========
// implements Flyable, Swimmable, Walkable → 鸭子同时拥有三种能力
// 必须实现三个接口中的所有方法
class Duck implements Flyable, Swimmable, Walkable {
    private String name;

    public Duck(String name) {
        this.name = name;
    }

    // 实现 Flyable 的方法
    @Override
    public void fly() {
        System.out.println(name + "鸭子在飞行");
    }

    @Override
    public void land() {
        System.out.println(name + "鸭子降落");
    }

    // 实现 Swimmable 的方法
    @Override
    public void swim() {
        System.out.println(name + "鸭子在游泳");
    }

    @Override
    public void dive() {
        System.out.println(name + "鸭子在潜水");
    }

    // 实现 Walkable 的方法
    @Override
    public void walk() {
        System.out.println(name + "鸭子在走路");
    }

    @Override
    public void stop() {
        System.out.println(name + "鸭子停止移动");
    }
}

// ========== 实现类3：鱼（只实现游泳接口）==========
class Fish implements Swimmable {
    private String name;

    public Fish(String name) {
        this.name = name;
    }

    @Override
    public void swim() {
        System.out.println(name + "鱼在游泳");
    }

    @Override
    public void dive() {
        System.out.println(name + "鱼在深潜");
    }
}

// ========== 演示 ==========
class InterfaceDemo {
    public static void main(String[] args) {
        System.out.println("========== 接口演示 ==========\n");

        // 用接口类型引用对象 —— 只能看到接口定义的方法
        // Flyable bird → 只能调用 fly() 和 land()，不能调用其他方法
        System.out.println("--- Flyable接口 ---");
        Flyable bird = new Bird("鹦鹉");
        bird.fly();
        bird.land();

        // 实现多个接口的对象，可以调用所有接口的方法
        System.out.println("\n--- 实现多个接口 ---");
        Duck duck = new Duck("唐老鸭");
        duck.walk();
        duck.fly();
        duck.swim();
        duck.dive();
        duck.stop();

        System.out.println("\n--- Swimmable接口 ---");
        Swimmable fish = new Fish("金鱼");
        fish.swim();
        fish.dive();

        // 【接口的多态】用接口数组存储不同类型的对象
        // 所有实现了 Flyable 的对象都可以放进来
        System.out.println("\n--- 飞行竞技大赛 ---");
        Flyable[] flyers = {bird, duck};  // 鸟和鸭子都能飞
        for (Flyable flyer : flyers) {
            flyer.fly();  // 各自执行自己的 fly() 实现
        }
    }
}
