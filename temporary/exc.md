Java程序设计习题
 
一、单项选择题（本大题共15小题，每小题2分，共30分） 
 
1.  Java源文件的扩展名是【 A  】。  
   A. .java  
   B. .class  
   C. .exe  
   D. .jar
 
2.  关于类的构造方法，下列说法错误的是【  D  】。  
   A. 构造方法没有返回类型  
   B. 构造方法可以重载  
   C. 构造方法可以被private修饰  
   D. 构造方法必须显式定义
 
3.  下列选项中，不是Java关键字的是【  D  】。  
   A. goto  
   B. true  
   C. final  
   D. implement
 
4.  在UML类图中，符号表示【  A  】。  
   A. private  
   B. protected  
   C. public  
   D. 包访问权限
 
5.  关于继承，下列说法正确的是【 D   】。  
   A. Java支持多继承  
   B. 子类可以继承父类的构造方法  
   C. 子类可以重写父类的final方法  
   D. super关键字用于访问父类成员
 
6.  编译并运行以下程序，结果是【 C   】。  
java
class A {
   public void show() {
       System.out.print("A");
   }
}
class B extends A {
   public void show() {
       System.out.print("B");
   }
}
public class Test {
   public static void main(String[] args) {
       A a = new B();
       a.show();
   }
}
 
A. 编译错误  
B. 输出 A  
C. 输出 B  
D. 运行无输出
 
7.  下列哪段代码无法通过编译【  C  】。  
java
class Animal {
   void eat() {}
}
class Dog extends Animal {
   // 此处插入代码
}
 
A. void eat() {}  
B. void eat(String food) {}  
C. int eat() { return 0; }  
D. void eat(int times) {}
 
8.  关于多态，下列说法正确的是【  A  】。  
A. 多态只发生在继承关系中  
B. 父类引用不能指向子类对象  
C. 多态下调用方法由引用类型决定  
D. 多态不能用于接口
 
9.  对于以下代码，错误的是【 D   】。  
java
class Parent {}
class Child extends Parent {}
public class Test {
   public static void main(String[] args) {
       // 此处插入代码
   }
}
 
A. Parent p = new Child();  
B. Child c = new Child(); Parent p = c;  
C. Parent p = new Child(); Child c = (Child)p;  
D. Child c = new Parent();
 
10. 关于接口的说法，正确的是【 B   】。  
   A. 接口中只能有抽象方法  
   B. 接口中的变量默认是public static final  
   C. 接口可以使用new直接实例化  
   D. 接口中的方法默认是private
 
11. 用于手动抛出异常对象的关键字是【 D   】。  
   A. try  
   B. catch  
   C. throws  
   D. throw
 
12. 关于异常处理，说法正确的是【  B  】。  
   A. try块后面必须跟catch块  
   B. finally块一定会执行  
   C. 多个catch块时，子类异常应放在父类后面   
   D. finally块可以没有try块
 
13. 关于线程，说法错误的是【  C  】。  
   A. 继承Thread类可以创建线程  
   B. start()方法会调用run()方法  
   C. 直接调用run()方法会启动新线程  
   D. 线程调度由JVM决定
 
14. 以下哪个代码能正确创建并启动线程【  C  】。  
java
class Task implements Runnable {
   public void run() {
       System.out.println("Run");
   }
}
 
A. Task.start();  
B. new Thread(Task).start();  
C. new Thread(new Task()).start();  
D. new Task().start();
 
15. 下列哪个类用于向文件写入字节数据【 D 】。  
   A. FileReader  
   B. FileWriter  
   C. FileInputStream  
   D. FileOutputStream
 
 
 
二、判断题（本大题共10小题，每小题1分，共10分） 
 
1.  一个Java源文件中只能有一个类。【  f  】  
2.  抽象类不能实例化，但可以有构造方法。【  t  】  
3.  final类可以被继承。【  f  】  
4.  static方法可以访问非static成员变量。【 f   】  
5.  接口中的方法默认是public abstract。【  t  】  
6.  子类不会继承父类的构造方法。【  t  】  
7.  this()和super()可以同时出现在同一个构造方法中。【  f  】  
8.  无论是否发生异常，finally块都会执行。【  t  】  
9.  UDP是面向连接的可靠传输协议。【  f  】  
10. synchronized可以解决线程安全问题。【 t   】
 
 
 
三、填空题（本大题共10小题，每小题1分，共10分） 
 
1.  super关键字用于访问父类的___成员变量_______。  
2.  如果一个类中有一个抽象方法，那么这个类必须是__abstract________类。  
3.  同一个类中多个方法同名但参数列表不同，称为方法的__reload________。  
4.  被___static_______修饰的成员属于类，而不是实例。  
5.  阅读程序，输出结果为___e_______。  
java
public class Test {
   public static void main(String[] args) {
       String str = "Hello";
       System.out.println(str.indexOf('l'));
   }
}
 
6.  使用import java.util.;语句导入了__________包中的所有类。  
7.  可以用___try_catch______块捕获和处理异常。  
8.  如果一个类实现了接口但不实现所有抽象方法，它必须声明为____抽象类______。  
9.  被final修饰的变量称为__常量________，只能赋值一次。  
10. 一个类可以实现多个接口，但只能__继承________一个父类。
 
 
 
四、阅读程序题（本大题共6小题，每小题5分，共30分） 
 
1.  运行结果：__Derived________  
java
class Base {
   void show() {
       System.out.println("Base");
   }
}
class Derived extends Base {
   void show() {
       System.out.println("Derived");
   }
   public static void main(String[] args) {
       Base b = new Derived();
       b.show();
   }
}
 
 
2.  运行结果：__5,10________  
java
class Data {
   int value = 5;
}
class TestData {
   void change(Data d) {
       d.value = 10;
   }
   public static void main(String[] args) {
       Data d = new Data();
       System.out.print(d.value + ", ");
       new TestData().change(d);
       System.out.print(d.value);
   }
}
 
 
3.  运行结果：____Guitar______  
java
interface Playable {
   void play();
}
class Guitar implements Playable {
   public void play() {
       System.out.println("Guitar");
   }
   public static void main(String[] args) {
       Playable p = new Guitar();
       p.play();
   }
}
 
 
4.  运行结果：____B______  
java
class A {
   A() {
       System.out.print("A ");
   }
}
class B extends A {
   B() {
       System.out.print("B ");
   }
   public static void main(String[] args) {
       new B();
   }
}
 
 
5.  运行结果：_____20 10_____  
java
public class ThisDemo {
   int a = 10;
   void test(int a) {
       System.out.println(a);
       System.out.println(this.a);
   }
   public static void main(String[] args) {
       new ThisDemo().test(20);
   }
}
 
 
6.  运行结果：___100_______  
java
public class ArrayTest {
   void change(int[] arr) {
       arr[0] = 100;
   }
   public static void main(String[] args) {
       int[] a = {1, 2, 3};
       new ArrayTest().change(a);
       System.out.println(a[0]);
   }
}
 
 
 
 
五、编程题（本大题共2小题，每小题10分，共20分） 
 
1.  编程题1  
   定义一个BankAccount类，属性包括：  
   - accountNumber（String类型，账号）  
   - balance（double类型，余额）  
   要求：  
   - 提供构造方法初始化账号和余额（余额不能为负，若为负则设为0并提示）  
   - 提供deposit(double amount)存款方法（金额必须大于0）  
   - 提供withdraw(double amount)取款方法（余额不足时提示“余额不足”且不扣款）  
- 提供getBalance()方法返回余额  
 
class BankAccount{
    String accountNumber;
    double balance;
 
    BankAccount(String accountNumber,double balance){
        this.accountNumber = accountNumber;
       
        if(balance<0){
            System.out.println("余额不能为负数，已设为0");
            this.balance = 0;
        }else{
            this.balance = balance;
        }
    }
 
    public double withdraw(double amount){
        if(amount>balance){
            System.out.println("钱不够");
        }else{
            balance=balance-amount;
           
        }
        System.out.println("余额："+balance);
        return balance;
    }
 
    public double deposit(double amount){
        if(amount>0){
            balance=balance+amount;
        }else{
            System.out.println("必须存到钱");
        }
        return balance;
    }
 
    public void getBalance(){
        System.out.println("当前余额:"+balance);
    }
 

}
 
 
2.  编程题2  
   模拟支付行为：  
   - 定义接口Payable，包含方法pay(double amount)  
   - 创建两个实现类：CreditCard（信用卡）和AliPay（支付宝），分别输出“信用卡支付xxx元”和“支付宝支付xxx元”  
   - 创建PaymentProcessor类，其中包含一个方法processPayment(Payable p, double amount)，该方法能对任意Payable类型的对象进行支付（体现接口回调）  
   - 在main方法中测试使用信用卡和支付宝分别支付
​
 
interface Payable{
    public void pay(double amount);
}

CreditCard implements Payable{
    public void pay(double amount){
        System.out.println("信用卡支付"+amount+"元");
    }
}


AliPay implements Payable{
    public void pay(double amount){
        System.out.println("支付宝支付"+amount+"元");
    }
}

PaymentProcessor{
    public void processPayment(Payable p,double amount){
        p.pay(amount);
    }
}

public class Test{
    public static void main(String[] args){
        PaymentProcessor processor = new PaymentProcessor();
        Payable creditCard = new CreditCard();
        Payable aliPay = new AliPay();
       
        processor.processPayment(creditCard,100);
        processor.processPayment(aliPay,200);
    }
}