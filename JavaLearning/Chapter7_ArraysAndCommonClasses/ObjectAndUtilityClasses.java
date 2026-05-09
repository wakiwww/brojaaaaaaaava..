/**
 * 第7章 - 7.2 Object类 & 7.4 Math与Random类
 *
 * 【Object 类】所有类的祖先
 *   Java 中每个类都直接或间接继承 Object
 *   所以所有对象都能调用 Object 的方法
 *
 * 【Object 常用方法】
 *   toString()  → 返回对象的字符串描述（默认是类名@哈希值，通常需要重写）
 *   equals()    → 比较对象是否"相等"（默认和 == 一样比较引用，通常需要重写）
 *   hashCode()  → 返回哈希值（重写 equals 时必须同时重写 hashCode）
 *   getClass()  → 返回对象的类信息
 *
 * 【Math 类】数学工具类，所有方法都是 static，直接用 Math.xxx() 调用
 *   Math.abs()   绝对值    Math.sqrt()  平方根    Math.pow(a,b)  a的b次方
 *   Math.max()   最大值    Math.min()   最小值    Math.round()   四舍五入
 *   Math.ceil()  向上取整  Math.floor() 向下取整  Math.random()  0~1随机数
 *
 * 【Random 类】生成随机数
 *   nextInt(n)    → 0 到 n-1 的随机整数
 *   nextDouble()  → 0 到 1 的随机小数
 *   nextBoolean() → 随机 true/false
 */

public class ObjectAndUtilityClasses {

    // ========== Object 类演示 ==========
    static class ObjectDemo {
        static class Person {
            private String name;
            private int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            // 【重写 toString】
            // 默认的 toString 返回 "类名@哈希值"，没有可读性
            // 重写后，System.out.println(person) 会输出有意义的信息
            @Override
            public String toString() {
                return "Person{name='" + name + "', age=" + age + "}";
            }

            // 【重写 equals】
            // 默认的 equals 和 == 一样，只比较引用（是否同一个对象）
            // 重写后，可以比较对象的属性值是否相同
            @Override
            public boolean equals(Object obj) {
                // 1. 同一个对象 → true
                if (this == obj) return true;
                // 2. null 或不同类型 → false
                if (obj == null || getClass() != obj.getClass()) return false;
                // 3. 比较属性值
                Person person = (Person) obj;  // 向下转型
                return age == person.age && name.equals(person.name);
            }

            // 【重写 hashCode】
            // 规则：如果 equals 返回 true，hashCode 必须相同
            // 所以重写 equals 时必须同时重写 hashCode
            @Override
            public int hashCode() {
                return java.util.Objects.hash(name, age);
            }

            public String getName() { return name; }
            public int getAge() { return age; }
        }

        public static void main(String[] args) {
            System.out.println("=== Object类演示 ===\n");

            Person p1 = new Person("Alice", 25);
            Person p2 = new Person("Alice", 25);  // 内容相同，但是不同对象
            Person p3 = p1;                        // p3 和 p1 指向同一个对象

            // equals vs ==
            System.out.println("p1.equals(p2): " + p1.equals(p2));  // true（内容相同）
            System.out.println("p1 == p2: " + (p1 == p2));          // false（不同对象）
            System.out.println("p1 == p3: " + (p1 == p3));          // true（同一个对象）

            // toString：重写后输出有意义的内容
            System.out.println("p1.toString(): " + p1.toString());
            System.out.println("p1: " + p1);  // println 会自动调用 toString

            // hashCode：内容相同的对象，哈希值也相同
            System.out.println("p1.hashCode(): " + p1.hashCode());
            System.out.println("p2.hashCode(): " + p2.hashCode());

            // getClass：获取对象的类信息
            System.out.println("p1.getClass(): " + p1.getClass());
            System.out.println("类名: " + p1.getClass().getName());

            // instanceof：判断对象是否是某个类型
            System.out.println("p1 instanceof Person: " + (p1 instanceof Person));
            System.out.println("p1 instanceof Object: " + (p1 instanceof Object));
        }
    }

    // ========== Math 类 ==========
    static class MathDemo {
        public static void main(String[] args) {
            System.out.println("\n=== Math类演示 ===\n");

            // 常数
            System.out.println("π = " + Math.PI);
            System.out.println("e = " + Math.E);

            // 基本运算
            System.out.println("abs(-5) = " + Math.abs(-5));           // 绝对值 → 5
            System.out.println("sqrt(16) = " + Math.sqrt(16));         // 平方根 → 4.0
            System.out.println("pow(2, 3) = " + Math.pow(2, 3));       // 2的3次方 → 8.0
            System.out.println("max(3, 7) = " + Math.max(3, 7));       // 最大值 → 7
            System.out.println("min(3, 7) = " + Math.min(3, 7));       // 最小值 → 3

            // 三角函数（参数是弧度，不是角度）
            double angle = Math.PI / 4;  // 45度 = π/4 弧度
            System.out.println("sin(45°) = " + Math.sin(angle));
            System.out.println("cos(45°) = " + Math.cos(angle));
            System.out.println("tan(45°) = " + Math.tan(angle));

            // 对数和指数
            System.out.println("log10(10) = " + Math.log10(10));       // 以10为底 → 1.0
            System.out.println("ln(e) = " + Math.log(Math.E));         // 自然对数 → 1.0
            System.out.println("exp(1) = " + Math.exp(1));             // e^1

            // 舍入
            System.out.println("ceil(3.2) = " + Math.ceil(3.2));       // 向上 → 4.0
            System.out.println("floor(3.8) = " + Math.floor(3.8));     // 向下 → 3.0
            System.out.println("round(3.5) = " + Math.round(3.5));     // 四舍五入 → 4
        }
    }

    // ========== Random 类 ==========
    static class RandomDemo {
        public static void main(String[] args) {
            System.out.println("\n=== Random类演示 ===\n");

            java.util.Random random = new java.util.Random();

            // 随机整数：nextInt(n) 返回 0 到 n-1
            System.out.println("随机整数(0-99): " + random.nextInt(100));
            System.out.println("随机整数(1-10): " + (random.nextInt(10) + 1));  // +1 偏移范围

            // 随机小数：nextDouble() 返回 0.0 到 1.0
            System.out.println("随机浮点数(0-1): " + random.nextDouble());
            System.out.println("随机浮点数(0-100): " + (random.nextDouble() * 100));

            // 生成多个骰子结果
            System.out.println("\n生成6个随机骰子结果:");
            for (int i = 0; i < 6; i++) {
                System.out.print((random.nextInt(6) + 1) + " ");  // 1~6
            }
            System.out.println();

            // 随机布尔值
            System.out.println("\n随机布尔值:");
            for (int i = 0; i < 5; i++) {
                System.out.println("第" + (i + 1) + "次: " + random.nextBoolean());
            }

            // 带种子的随机数：相同种子 → 相同的随机序列（可重现）
            System.out.println("\n--- 带种子的随机数 ---");
            java.util.Random seededRandom = new java.util.Random(42);
            System.out.println("种子为42的随机数:");
            for (int i = 0; i < 3; i++) {
                System.out.print(seededRandom.nextInt(10) + " ");
            }
            System.out.println();
        }
    }

    // ========== 实际应用：验证码生成 ==========
    static class VerificationCodeGenerator {
        static String generateCode(int length) {
            java.util.Random random = new java.util.Random();
            StringBuilder code = new StringBuilder();
            String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

            for (int i = 0; i < length; i++) {
                // random.nextInt(chars.length()) → 随机索引
                // chars.charAt(index) → 取出对应字符
                code.append(chars.charAt(random.nextInt(chars.length())));
            }
            return code.toString();
        }

        public static void main(String[] args) {
            System.out.println("\n--- 验证码生成 ---");
            for (int i = 0; i < 5; i++) {
                System.out.println("验证码: " + generateCode(6));
            }
        }
    }

    public static void main(String[] args) {
        ObjectDemo.main(args);
        MathDemo.main(args);
        RandomDemo.main(args);
        VerificationCodeGenerator.main(args);
    }
}
