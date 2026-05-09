/**
 * 第6章 - 6.5 Lambda表达式
 *
 * 【核心概念】Lambda = 匿名函数（没有名字的方法）
 *   语法：(参数) -> { 方法体 }
 *   目的：简化代码，特别是"只用一次的小方法"
 *
 * 【函数式接口】
 *   Lambda 必须配合"函数式接口"使用
 *   函数式接口 = 只有一个抽象方法的接口（用 @FunctionalInterface 标记）
 *   比如 Calculator 接口只有一个 calculate(a, b) 方法
 *
 * 【Lambda 的几种写法】
 *   (a, b) -> a + b           → 一行表达式，自动返回结果
 *   (a, b) -> { return a+b; } → 多行代码块，需要 return
 *   a -> a * 2                → 只有一个参数时可以省略括号
 *   () -> System.out.println("hi")  → 没有参数时写空括号
 *
 * 【Lambda vs 匿名内部类】
 *   Lambda 是匿名内部类的简写形式，更简洁易读
 */

// ========== 函数式接口：只有一个抽象方法 ==========
// @FunctionalInterface 不是必须的，但加上后如果写了多个抽象方法会编译报错，起保护作用
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);  // 唯一的抽象方法
}

@FunctionalInterface
interface Printer {
    void print(String message);
}

@FunctionalInterface
interface Filter {
    boolean test(int value);
}

// ========== 演示 ==========
class LambdaDemo {

    // 接收函数式接口作为参数 —— 这是 Lambda 最常见的使用场景
    // 调用时可以传入不同的 Lambda 表达式，实现不同的计算逻辑
    static void executeCalculation(int a, int b, Calculator calc) {
        int result = calc.calculate(a, b);
        System.out.println("计算结果: " + result);
    }

    static void executeFilter(int[] numbers, Filter filter) {
        System.out.print("满足条件的数字: ");
        for (int num : numbers) {
            if (filter.test(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("========== Lambda表达式演示 ==========\n");

        // ========== 1. 基础 Lambda ==========
        // 把 Lambda 赋值给变量，变量类型是函数式接口
        // (a, b) -> a + b 意思是：接收 a 和 b，返回 a + b
        System.out.println("--- 基础Lambda ---");
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;

        executeCalculation(10, 5, add);       // 15
        executeCalculation(10, 5, subtract);  // 5
        executeCalculation(10, 5, multiply);  // 50

        // ========== 2. Lambda 代码块 ==========
        // 当逻辑复杂时，用 {} 包起来，需要显式 return
        System.out.println("\n--- Lambda与代码块 ---");
        Calculator divide = (a, b) -> {
            if (b == 0) {
                System.out.println("错误：除数不能为0");
                return 0;  // 代码块里必须用 return 返回
            }
            return a / b;
        };
        executeCalculation(10, 5, divide);  // 2
        executeCalculation(10, 0, divide);  // 错误提示，返回 0

        // ========== 3. 不同接口的 Lambda ==========
        System.out.println("\n--- Printer接口 ---");
        Printer printUpper = msg -> System.out.println("大写: " + msg.toUpperCase());
        Printer printLower = msg -> System.out.println("小写: " + msg.toLowerCase());
        Printer printLength = msg -> System.out.println("长度: " + msg.length());

        printUpper.print("Hello Lambda");   // 大写: HELLO LAMBDA
        printLower.print("Hello Lambda");   // 小写: hello lambda
        printLength.print("Hello Lambda");  // 长度: 12

        // ========== 4. Filter 过滤器 ==========
        // 同一个 executeFilter 方法，传入不同的 Lambda 就能过滤出不同结果
        System.out.println("\n--- Filter接口 ---");
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Filter isEven = n -> n % 2 == 0;       // 偶数
        Filter isOdd = n -> n % 2 != 0;         // 奇数
        Filter isGreaterThan5 = n -> n > 5;     // 大于5

        executeFilter(numbers, isEven);          // 2 4 6 8 10
        executeFilter(numbers, isOdd);           // 1 3 5 7 9
        executeFilter(numbers, isGreaterThan5);  // 6 7 8 9 10

        // ========== 5. Lambda 与集合 ==========
        System.out.println("\n--- Lambda与集合 ---");
        java.util.List<String> fruits = new java.util.ArrayList<>();
        fruits.add("苹果");
        fruits.add("香蕉");
        fruits.add("橙子");
        fruits.add("葡萄");

        // forEach 接收一个 Lambda，对每个元素执行操作
        System.out.print("水果列表: ");
        fruits.forEach(fruit -> System.out.print(fruit + " "));
        System.out.println();

        // stream().filter() 用 Lambda 过滤集合
        System.out.print("名字长度大于2的水果: ");
        fruits.stream()
              .filter(fruit -> fruit.length() > 2)
              .forEach(fruit -> System.out.print(fruit + " "));
        System.out.println();
    }
}
