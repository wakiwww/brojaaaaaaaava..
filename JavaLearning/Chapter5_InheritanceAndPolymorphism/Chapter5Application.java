package Chapter5_InheritanceAndPolymorphism;

public class Chapter5Application {
    public static void main(String[] args) {
        System.out.println("=== 多态辨析练习 ===\n");

        // 定义一个父类引用指向子类对象
        Animal a = new Dog();

        // ---- 问题1：下面哪些能编译通过？ ----
        // 逐个取消注释运行，观察结果或报错

        a.speak();
        // a.fetch();      // ← 这行能编译通过吗？
        // a.swim();       // ← 这行能编译通过吗？

        // ---- 问题2：a.speak() 实际执行的是谁的代码？ ----
        // Animal的speak() 还是 Dog的speak()？

        // ---- 问题3：画出内存图 ----
        // a这个变量在栈里存的是什么？
        // Dog对象在堆里有哪些内容？

        System.out.println("\n=== 答案在下面，先自己想！ ===\n");
        // 取消下面注释查看答案
        // showAnswer();
    }

    static void showAnswer() {
        System.out.println("【问题1答案】");
        System.out.println("a.speak()  → 编译通过 ✅  (Animal里有speak)");
        System.out.println("a.fetch()  → 编译报错 ❌  (Animal里没有fetch)");
        System.out.println("a.swim()   → 编译报错 ❌  (Animal里没有swim)");
        System.out.println();
        System.out.println("【问题2答案】");
        System.out.println("执行的是 Dog的speak()，输出 Dog barks");
        System.out.println("因为a虽然标签是Animal，但里面装的是Dog对象");
        System.out.println("Dog重写了speak()，所以运行时执行子类版本");
        System.out.println();
        System.out.println("【问题3答案】");
        System.out.println("栈: a(Animal引用) ──指向──> 堆: Dog对象");
        System.out.println("Dog对象里有: Animal的属性 + Dog重写的speak() + Dog特有的fetch()");
    }
}

// ========== 需要的类定义 ==========

class Animal {
    public void speak() {
        System.out.println("Animal speaks");
    }
}

class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("Dog barks");
    }

    public void fetch() {
        System.out.println("Dog fetches ball");
    }

    public void swim() {
        System.out.println("Dog swims");
    }
}

// ========== 延伸思考题（写在纸上） ==========
//
// 如果把代码改成这样，结果分别是什么？
//
// 情况A:  Animal a = new Dog();
//         a.speak();
//         Dog d = (Dog) a;
//         d.fetch();
//
// 情况B:  Animal a = new Dog(); 
//         Dog d = a;           // 这行能编译吗？
//
// 情况C:  Dog d = new Dog();
//         Animal a = d;        // 这行能编译吗？
//         a.speak();           // 输出什么？
//
// 情况D:  Animal a = new Animal();
//         Dog d = (Dog) a;    // 这行编译通过，但运行时会怎样？

// =====================================================================
// 编程题1：Student类
// =====================================================================

class Student {
    private String id;
    private String name;
    private double score;

    // 构造方法，分数必须在0-100之间
    public Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
        setScore(score);  // 用setScore来校验，避免重复代码
    }

    // getter方法
    public String getId() { return id; }
    public String getName() { return name; }
    public double getScore() { return score; }

    // 设置分数，校验范围
    public void setScore(double score) {
        if (score < 0 || score > 100) {
            System.out.println("分数超出范围，已设置为0");
            this.score = 0;
        } else {
            this.score = score;
        }
    }

    // 加分
    public void addScore(double points) {
        setScore(this.score + points);
    }

    // 减分
    public void deductScore(double points) {
        if (this.score < points) {
            System.out.println("分数不足，操作失败");
        } else {
            setScore(this.score - points);
        }
    }

    public static void main(String[] args) {
        Student s = new Student("001", "张三", 80);
        System.out.println("姓名: " + s.getName() + ", 分数: " + s.getScore());

        s.addScore(15);
        System.out.println("加15分后: " + s.getScore());

        s.deductScore(10);
        System.out.println("减10分后: " + s.getScore());

        s.deductScore(200);  // 分数不足
        System.out.println("减200分后: " + s.getScore());

        Student s2 = new Student("002", "李四", 150);  // 超出范围
    }
}

// =====================================================================
// 编程题2：接口回调 - 动物训练
// =====================================================================

// 定义Trainable接口
interface Trainable {
    void sit();      // 坐下
    void rollOver(); // 翻滚
}

// Dog实现Trainable接口
class TrainableDog implements Trainable {
    private String name;

    public TrainableDog(String name) {
        this.name = name;
    }

    @Override
    public void sit() {
        System.out.println(name + "乖乖坐下了");
    }

    @Override
    public void rollOver() {
        System.out.println(name + "开心地翻了个滚");
    }
}

// Cat实现Trainable接口
class TrainableCat implements Trainable {
    private String name;

    public TrainableCat(String name) {
        this.name = name;
    }

    @Override
    public void sit() {
        System.out.println(name + "勉强坐下了（但随时会走）");
    }

    @Override
    public void rollOver() {
        System.out.println(name + "用看傻子的眼神看着你");
    }
}

// AnimalTrainer训练员类
class AnimalTrainer {
    // 训练方法：接收Trainable接口类型（接口回调）
    public void train(Trainable animal, String command) {
        System.out.println("--- 训练开始 ---");
        switch (command) {
            case "sit":
                animal.sit();
                break;
            case "rollOver":
                animal.rollOver();
                break;
            default:
                System.out.println("不懂这个指令");
        }
        System.out.println("--- 训练结束 ---\n");
    }

    public static void main(String[] args) {
        AnimalTrainer trainer = new AnimalTrainer();

        // 训练Dog
        Trainable dog = new TrainableDog("旺财");
        trainer.train(dog, "sit");
        trainer.train(dog, "rollOver");

        // 训练Cat
        Trainable cat = new TrainableCat("咪咪");
        trainer.train(cat, "sit");
        trainer.train(cat, "rollOver");
    }
}
