/**
 * 第5章 - 5.4 多态
 *
 * 【核心概念】多态 = 同一个方法调用，不同对象产生不同行为
 *   类比：都是"跑"，汽车在公路上跑，飞机在天上飞
 *
 * 【实现条件】
 *   1. 有继承关系（子类 extends 父类）
 *   2. 子类重写了父类的方法（@Override）
 *   3. 父类引用指向子类对象（Vehicle car = new Car(...)）
 *
 * 【关键理解】编译看左边，运行看右边
 *   - 编译时：变量类型是 Vehicle，所以只能调用 Vehicle 有的方法
 *   - 运行时：实际对象是 Car，所以调用的是 Car 重写后的方法
 *
 * 【instanceof 和向下转型】
 *   - instanceof：检查对象实际是什么类型（if (vehicle instanceof Car)）
 *   - 向下转型：把父类引用强制转回子类类型，才能调用子类特有方法
 */

public class Polymorphism {

    // ========== 父类：交通工具 ==========
    static class Vehicle {
        protected String name;

        public Vehicle(String name) {
            this.name = name;
        }

        // 父类定义的方法 —— 子类会重写它，这就是多态的基础
        public void run() {
            System.out.println(name + "在运行");
        }

        public void stop() {
            System.out.println(name + "已停止");
        }
    }

    // ========== 子类：汽车 ==========
    static class Car extends Vehicle {
        public Car(String name) {
            super(name);  // 调用父类构造
        }

        // 【重写】汽车有自己"跑"和"停"的方式
        @Override
        public void run() {
            System.out.println(name + "汽车在公路上行驶");
        }

        @Override
        public void stop() {
            System.out.println(name + "汽车踩了刹车停止");
        }

        // Car 特有的方法（Vehicle 没有）
        public void openTrunk() {
            System.out.println(name + "打开后备箱");
        }
    }

    // ========== 子类：飞机 ==========
    static class Plane extends Vehicle {
        public Plane(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(name + "飞机在空中飞行");
        }

        @Override
        public void stop() {
            System.out.println(name + "飞机降落停止");
        }

        // Plane 特有的方法
        public void takeOff() {
            System.out.println(name + "飞机起飞");
        }
    }

    // ========== 演示多态的应用 ==========
    static class TransportationService {
        // 【多态的关键】参数类型是父类 Vehicle，但传入的可以是任何子类对象
        // 这样一个方法就能处理 Car、Plane、以及未来可能的 Train、Ship...
        public void startJourney(Vehicle vehicle) {
            System.out.println("\n--- 开始旅程 ---");
            // 这里调用 vehicle.run()，实际执行的是子类重写后的版本
            // 如果传的是 Car → 打印"汽车在公路上行驶"
            // 如果传的是 Plane → 打印"飞机在空中飞行"
            vehicle.run();
        }

        public void endJourney(Vehicle vehicle) {
            System.out.println("--- 结束旅程 ---");
            vehicle.stop();
        }

        // 【instanceof + 向下转型】
        // 父类引用只能调用父类有的方法（run、stop）
        // 如果想调用子类特有方法（openTrunk、takeOff），需要先判断类型再强转
        public void specialOperation(Vehicle vehicle) {
            if (vehicle instanceof Car) {
                // 先判断是 Car 类型，再强制转为 Car
                ((Car) vehicle).openTrunk();  // 现在可以调用 Car 特有方法了
            } else if (vehicle instanceof Plane) {
                ((Plane) vehicle).takeOff();  // 调用 Plane 特有方法
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("========== 多态演示 ==========\n");

        // 【多态的核心写法】父类引用 = 子类对象
        // 变量类型是 Vehicle，但实际对象是 Car
        Vehicle car = new Car("法拉利");
        Vehicle plane = new Plane("波音747");

        // 同一个方法 startJourney()，传入不同对象，行为不同
        TransportationService service = new TransportationService();

        service.startJourney(car);    // → 汽车在公路上行驶
        service.endJourney(car);      // → 汽车踩了刹车停止

        service.startJourney(plane);  // → 飞机在空中飞行
        service.endJourney(plane);    // → 飞机降落停止

        // 调用子类特有方法，需要向下转型
        System.out.println("\n--- 特殊操作 ---");
        service.specialOperation(car);    // → 打开后备箱
        service.specialOperation(plane);  // → 飞机起飞
    }
}
