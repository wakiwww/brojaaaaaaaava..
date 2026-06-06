/**
 * 第10章 - Java多线程
 *
 * 【核心概念】多线程 = 同时做多件事
 *   单线程：排队做，前一个做完才能做下一个
 *   多线程：多个任务同时进行（CPU在不同线程间快速切换）
 *
 * 【创建线程的方式】
 *   1. 实现 Runnable 接口（推荐，灵活）
 *   2. 继承 Thread 类（简单，但有局限）
 *
 * 【线程控制】
 *   sleep() — 让线程暂停一段时间
 *   join()  — 等待另一个线程结束
 *   synchronized — 同步，防止多个线程同时修改同一数据
 */

public class Chapter10Application {
    public static void main(String[] args) {
        System.out.println("========== 10.1 实现 Runnable 接口 ==========\n");

        // Runnable 是一个接口，只有一个抽象方法 run()
        // 创建线程时传入 Runnable，线程启动后会执行 run()
        Runnable gameTask = new GameTask("冒险游戏");
        Runnable musicTask = new GameTask("背景音乐");

        Thread t1 = new Thread(gameTask);
        Thread t2 = new Thread(musicTask);

        t1.start();  // 启动线程，执行 run()
        t2.start();

        // main 线程继续执行
        System.out.println("主线程：初始化游戏中...");

        // 等待子线程结束
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.out.println("线程被中断");
        }

        System.out.println("主线程：所有任务完成\n");

        System.out.println("========== 10.2 继承 Thread 类 ==========\n");

        MyThread mt1 = new MyThread("线程A");
        MyThread mt2 = new MyThread("线程B");
        mt1.start();
        mt2.start();

        try {
            mt1.join();
            mt2.join();
        } catch (InterruptedException e) {
            System.out.println("线程被中断");
        }

        System.out.println("\n========== 10.3 线程控制 ==========\n");

        // sleep：让当前线程暂停
        System.out.println("开始...");
        for (int i = 3; i > 0; i--) {
            System.out.println("倒计时: " + i);
            try {
                Thread.sleep(1000);  // 暂停1秒
            } catch (InterruptedException e) {
                System.out.println("被中断");
            }
        }
        System.out.println("GO!\n");

        System.out.println("========== 10.4 线程同步 synchronized ==========\n");

        // 模拟多线程同时操作银行账户
        BankAccount account = new BankAccount("雪乃", 10000);

        Runnable depositTask = () -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(1000);
            }
        };

        Runnable withdrawTask = () -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(500);
            }
        };

        Thread depThread = new Thread(depositTask);
        Thread witThread = new Thread(withdrawTask);

        depThread.start();
        witThread.start();

        try {
            depThread.join();
            witThread.join();
        } catch (InterruptedException e) {
            System.out.println("被中断");
        }

        System.out.println("最终余额: " + account.getBalance());
        System.out.println("期望余额: " + (10000 + 5000 - 2500) + " = 12500");
    }
}

// 方式一：实现 Runnable 接口
class GameTask implements Runnable {
    private String taskName;

    public GameTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(taskName + ": 开始运行");
        try {
            Thread.sleep(500);  // 模拟耗时操作
        } catch (InterruptedException e) {
            System.out.println(taskName + ": 被中断");
        }
        System.out.println(taskName + ": 运行结束");
    }
}

// 方式二：继承 Thread 类
class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(getName() + ": " + (i + 1));
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println(getName() + ": 被中断");
            }
        }
    }
}

// 银行账户（线程同步示例）
class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    // synchronized — 同一时间只有一个线程能执行这个方法
    // 防止两个线程同时操作余额导致数据错误
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("存款 +" + amount + "，余额: " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("取款 -" + amount + "，余额: " + balance);
        } else {
            System.out.println("余额不足，无法取款 " + amount);
        }
    }

    public double getBalance() {
        return balance;
    }
}
