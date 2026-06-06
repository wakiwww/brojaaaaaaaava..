/**
 * 第9章 - 异常处理
 *
 * 【核心概念】异常 = 程序运行时发生的意外事件
 *   没有异常处理：程序直接崩溃
 *   有异常处理：程序可以捕获错误，继续运行或优雅退出
 *
 * 【异常体系】
 *   Throwable
 *   ├── Error（严重错误，程序无法处理，如内存溢出）
 *   └── Exception（异常，程序可以处理）
 *       ├── 编译时异常（必须处理，如文件找不到）
 *       └── RuntimeException（运行时异常，可以不处理，如除零）
 *
 * 【处理方式】
 *   try-catch：捕获并处理异常
 *   throws：声明方法可能抛出的异常，交给调用者处理
 *   throw：手动抛出一个异常
 *   finally：无论是否发生异常，都会执行的代码
 */

import java.io.*;

public class Chapter9Application {
    public static void main(String[] args) {
        System.out.println("========== 9.1 try-catch ==========\n");

        // 除零异常
        try {
            int a = 10;
            int b = 0;
            int result = a / b;  // 会抛出 ArithmeticException
            System.out.println("结果: " + result);
        } catch (ArithmeticException e) {
            System.out.println("捕获除零异常: " + e.getMessage());
        }

        // 数组越界异常
        try {
            int[] arr = {1, 2, 3};
            int value = arr[10];  // 会抛出 ArrayIndexOutOfBoundsException
            System.out.println("值: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("捕获数组越界: " + e.getMessage());
        }

        System.out.println("\n========== 9.2 多重 catch ==========\n");

        try {
            String str = null;
            str.length();  // 会抛出 NullPointerException
        } catch (NullPointerException e) {
            System.out.println("捕获空指针异常: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("捕获其他异常: " + e.getMessage());
        }

        System.out.println("\n========== 9.3 try-catch-finally ==========\n");

        try {
            int result = 10 / 5;
            System.out.println("结果: " + result);
        } catch (ArithmeticException e) {
            System.out.println("异常: " + e.getMessage());
        } finally {
            System.out.println("finally 块：无论是否异常都会执行");
        }

        System.out.println("\n========== 9.4 throws 声明异常 ==========\n");

        try {
            checkAge(15);  // 调用可能抛出异常的方法
        } catch (IllegalArgumentException e) {
            System.out.println("年龄验证失败: " + e.getMessage());
        }

        System.out.println("\n========== 9.5 throw 手动抛出 ==========\n");

        try {
            register("", "123456");
        } catch (IllegalArgumentException e) {
            System.out.println("注册失败: " + e.getMessage());
        }

        System.out.println("\n========== 9.6 自定义异常 ==========\n");

        try {
            withdraw(500, 1000);
        } catch (InsufficientBalanceException e) {
            System.out.println("取款失败: " + e.getMessage());
        }

        System.out.println("\n========== 9.7 异常处理最佳实践 ==========\n");

        System.out.println("1. 不要用空的 catch 块（会吞掉异常）");
        System.out.println("2. 捕获具体的异常类型，不要只用 Exception");
        System.out.println("3. 在 finally 中释放资源");
        System.out.println("4. 不要用异常控制流程（if 能解决的不要用 try）");
    }

    // throws 声明这个方法可能抛出异常，调用者必须处理
    public static void checkAge(int age) throws IllegalArgumentException {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("年龄必须在0-150之间，你输入了: " + age);
        }
        System.out.println("年龄合法: " + age);
    }

    // throw 手动抛出异常
    public static void register(String username, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("用户名不能为空");
        }
        if (password.length() < 6) {
            throw new IllegalArgumentException("密码长度不能少于6位");
        }
        System.out.println("注册成功: " + username);
    }

    // 自定义异常 + throw
    public static void withdraw(double amount, double balance)
            throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("余额不足，需要: " + amount + "，当前余额: " + balance);
        }
        System.out.println("取款成功: " + amount + "，剩余余额: " + (balance - amount));
    }
}

// 自定义异常类（继承 Exception）
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);  // 调用父类构造方法，设置错误信息
    }
}
