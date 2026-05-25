/**
 * 继承练习 - 饮品（Drink）系统
 *
 * 知识点：extends、super()、@Override、protected
 * 预计用时：10分钟
 *
 * 任务：
 *   1. 补全父类 Drink
 *   2. 创建子类 Coffee，继承 Drink
 *   3. 创建子类 Juice，继承 Drink
 *   4. 运行 main 方法，使输出与"期望输出"一致
 *
 * 期望输出：
 *   --- Coffee ---
 *   品名: 拿铁，价格: 28.0元
 *   拿铁 正在制作中...
 *   加了一份浓缩
 *   面积: 不适用
 *   --- Juice ---
 *   品名: 鲜榨橙汁，价格: 18.0元
 *   鲜榨橙汁 正在制作中...
 *   加了冰块
 */

// ========== 父类 Drink ==========
class Drink {

    // TODO: 添加 protected 属性 name（品名）
    protected String name;
    // TODO: 添加 private 属性 price（价格）
    protected double price;
    // TODO: 构造方法，接收 name 和 price
    protected Drink(String name ,double price){
        this.name = name;
        this.price = price;
    }
    // TODO: 方法 make()，输出 "{name} 正在制作中..."
    protected void make(){
        System.out.println(name + " 正在制作中...");
    }
    // TODO: 方法 info()，输出 "品名: {name}，价格: {price}元"
    protected void info(){
        System.out.println("品名: " + name + "，价格: " + price + "元");
    }
    // TODO: getPrice() getter
    protected double getPrice(){
        return price;
    }
}

// ========== 子类 Coffee ==========
// TODO: 继承 Drink
class Coffee extends Drink {

    // TODO: 构造方法，接收 name 和 price，用 super 调用父类构造
    protected Coffee(String name, double price){
        super(name,price);
    }

    // TODO: @Override make()，先调用父类的 make()，再输出 "加了一份浓缩"
    @Override 
    protected void make(){
        super.make();
        System.out.println("加了一份浓缩");}

    // TODO: 方法 addShot()，输出 "{name} 加了双份浓缩，价格变为 {price + 10}元"
    protected void addShot(){
        price += 10;
        System.out.println(name + " 加了双份浓缩，价格变为 " + price + "元");
    }

    }


// ========== 子类 Juice ==========
class Juice extends Drink {


// TODO: 继承 Drink

    // TODO: 构造方法，接收 name 和 price，用 super 调用父类构造
    protected Juice(String name, double price){
        super(name,price);
    }
       @Override
        protected void make(){
            super.make();
            System.out.println("加了冰块");
        }   
    // TODO: @Override make()，先调用父类的 make()，再输出 "加了冰块"

}

// ========== 主方法（已写好，不要改） ==========
public class Practice_04 {
    public static void main(String[] args) {
        System.out.println("--- Coffee ---");
        Coffee coffee = new Coffee("拿铁", 28.0);
        coffee.info();
        coffee.make();
        coffee.addShot();

        System.out.println("--- Juice ---");
        Juice juice = new Juice("鲜榨橙汁", 18.0);
        juice.info();
        juice.make();
    }
}
