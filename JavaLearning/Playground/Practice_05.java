/**
 * 继承练习 - 动物（Animal）系统
 *
 * 知识点：extends、super()、@Override、protected
 *
 * 任务：补全 Animal、Dog、Cat 三个类，使 main 方法输出与期望一致。
 *
 * 期望输出：
 *   --- Dog ---
 *   名字: 旺财，年龄: 3岁
 *   旺财 正在叫...
 *   汪汪汪！
 *   旺财 正在摇尾巴
 *   --- Cat ---
 *   名字: 咪咪，年龄: 2岁
 *   咪咪 正在叫...
 *   喵喵喵！
 */

// ========== 父类 Animal ==========
class Animal {
    protected String name;
    protected int age;
    Animal(String name,int age){
        this.name=name;
        this.age=age;
    }
    protected void speak(){
        System.out.println(name+"正在叫...");
    }
    protected void info(){
        System.out.println("我叫"+name);
    }
}


// ========== 子类 Dog ==========
class Dog extends Animal {
    protected Dog(String name,int age){
        super(name, age);
    }
    @Override
    protected void speak(){
        System.out.println(name+"正在叫>>>汪汪汪");

    }    
    protected void wagTail(){
        System.out.println("摇尾巴...汪！");
    }
}

// ========== 子类 Cat ==========
class Cat extends Animal {
    protected Cat(String name,int age){
        super(name,age);
    }
    @Override
    protected void speak(){
        System.out.println(name+"正在叫>>>喵！");
    }
}

// ========== 主方法（已写好，不要改） ==========
public class Practice_05 {
    public static void main(String[] args) {
        System.out.println("--- Dog ---");
        Dog dog = new Dog("旺财", 3);
        dog.info();
        dog.speak();
        dog.wagTail();

        System.out.println("--- Cat ---");
        Cat cat = new Cat("咪咪", 2);
        cat.info();
        cat.speak();
    }
}
