# Java学习资源索引

## 快速导航

### 📚 第4章：类和对象 (Classes and Objects)

| 知识点 | 文件 | 代码示例 | 实际应用 |
|--------|------|---------|--------|
| 基本类定义 | `BasicClass.java` | 属性、方法、getter/setter | 员工信息 |
| 对象创建 | `ObjectCreation.java` | 构造方法（无参/有参） | 汽车类 |
| this关键字 | `ThisAndStaticDemo.java` | this的用途、static类变量 | 对象计数 |
| 综合应用 | `Chapter4Application.java` | 学生管理 | 完整系统 |
| 测试程序 | `Chapter4Test.java` | 所有知识点演示 | 学习验证 |

**核心概念**：
```java
// 类的三要素：属性 + 方法 + 构造方法
public class ClassName {
    // 1. 属性
    private String name;
    
    // 2. 构造方法
    public ClassName(String name) {
        this.name = name;  // this代表当前对象
    }
    
    // 3. 方法
    public void doSomething() {}
}
```

---

### 📚 第5章：继承与多态 (Inheritance & Polymorphism)

| 知识点 | 文件 | 代码示例 | 实际应用 |
|--------|------|---------|--------|
| 基本继承 | `BasicInheritance.java` | extends、super、方法重写 | 动物→狗/鸟 |
| 多态应用 | `Polymorphism.java` | 向上转型、动态绑定、instanceof | 交通工具系统 |
| final关键字 | `FinalKeyword.java` | final类/方法/变量 | 不可变数据 |
| 综合应用 | `Chapter5Application.java` | 员工管理系统 | 薪资计算系统 |

**核心概念**：
```java
// 1. 继承
public class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗在吃骨头");
    }
}

// 2. 多态 - 父类引用指向子类对象
Animal dog = new Dog();
dog.eat();  // 调用Dog的实现，而不是Animal的

// 3. instanceof检查实际类型
if (animal instanceof Dog) {
    Dog d = (Dog) animal;  // 向下转型
}
```

---

### 📚 第6章：抽象类与接口 (Abstract Classes & Interfaces)

| 知识点 | 文件 | 代码示例 | 实际应用 |
|--------|------|---------|--------|
| 抽象类 | `AbstractClass.java` | abstract关键字、抽象方法 | 几何形状系统 |
| 接口 | `Interface.java` | interface、implements、多接口 | 鸭子类 |
| Lambda表达式 | `LambdaExpression.java` | 函数式接口、Lambda语法 | 计算器、过滤器 |
| 综合应用 | `Chapter6Application.java` | 支付系统 | 多种支付方式 |

**核心概念**：
```java
// 1. 抽象类
abstract class Shape {
    abstract double getArea();  // 抽象方法，子类必须实现
    public void draw() {}       // 具体方法，子类可继承
}

// 2. 接口
interface Flyable {
    void fly();
    void land();
}

// 3. 多接口实现
class Bird implements Flyable, Swimmable {}

// 4. Lambda表达式
Calculator add = (a, b) -> a + b;
```

---

### 📚 第7章：数组与常用类 (Arrays & Common Classes)

| 知识点 | 文件 | 代码示例 | 实际应用 |
|--------|------|---------|--------|
| 数组基础 | `ArrayBasics.java` | 一维/二维数组、排序、搜索 | 成绩数组处理 |
| 字符串类 | `StringAndBuilders.java` | String、StringBuilder、StringBuffer | 文本处理 |
| Object/Math/Random | `ObjectAndUtilityClasses.java` | equals、hashCode、Math运算、随机数 | 验证码生成 |
| 综合应用 | `Chapter7Application.java` | 成绩管理系统 | 学生数据处理 |

**核心概念**：
```java
// 1. 数组操作
int[] scores = {85, 90, 78};
Arrays.sort(scores);              // 排序
int index = Arrays.binarySearch(scores, 90);  // 查找

// 2. String处理
String text = "Hello World";
String[] words = text.split(" ");
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");             // 高效字符串连接

// 3. Math和Random
Math.max(3, 7);                  // 返回7
Math.sqrt(16);                   // 返回4
Random random = new Random();
int num = random.nextInt(100);   // 0-99的随机数

// 4. Object方法
@Override
public boolean equals(Object obj) { ... }
@Override
public int hashCode() { ... }
@Override
public String toString() { ... }
```

---

## 📊 知识点对照表

### 按难度分类

| 难度 | 知识点 | 章节 | 文件 |
|------|--------|------|------|
| ⭐ 初级 | 类和对象 | 4 | BasicClass.java |
| ⭐ 初级 | 属性和方法 | 4 | ObjectCreation.java |
| ⭐⭐ 中级 | this和static | 4 | ThisAndStaticDemo.java |
| ⭐⭐ 中级 | 继承 | 5 | BasicInheritance.java |
| ⭐⭐ 中级 | 多态 | 5 | Polymorphism.java |
| ⭐⭐ 中级 | final关键字 | 5 | FinalKeyword.java |
| ⭐⭐⭐ 高级 | 抽象类 | 6 | AbstractClass.java |
| ⭐⭐⭐ 高级 | 接口 | 6 | Interface.java |
| ⭐⭐⭐ 高级 | Lambda表达式 | 6 | LambdaExpression.java |
| ⭐ 初级 | 数组操作 | 7 | ArrayBasics.java |
| ⭐⭐ 中级 | 字符串处理 | 7 | StringAndBuilders.java |
| ⭐⭐ 中级 | Object和工具类 | 7 | ObjectAndUtilityClasses.java |

### 按关键字分类

| 关键字 | 含义 | 章节 | 用例 |
|--------|------|------|------|
| `new` | 创建对象 | 4 | `new Dog()` |
| `this` | 当前对象 | 4 | `this.name = name` |
| `static` | 类级别 | 4 | `static int count` |
| `extends` | 继承 | 5 | `class Dog extends Animal` |
| `super` | 父类 | 5 | `super.eat()` |
| `@Override` | 方法重写 | 5 | 标注重写的方法 |
| `instanceof` | 类型检查 | 5 | `obj instanceof Dog` |
| `final` | 不可修改 | 5 | `final int MAX = 10` |
| `abstract` | 抽象的 | 6 | `abstract class Shape` |
| `interface` | 接口 | 6 | `interface Flyable` |
| `implements` | 实现接口 | 6 | `class Dog implements Flyable` |
| `->` | Lambda | 6 | `(a, b) -> a + b` |

---

## 💡 常用代码片段

### 创建和初始化对象
```java
// 方式1：使用new关键字
Dog dog = new Dog("旺财");

// 方式2：使用构造方法重载
Dog dog = new Dog("旺财", 5);
```

### 继承和多态
```java
// 定义基类
class Animal {
    public void sound() {}
}

// 继承并重写方法
class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("汪汪");
    }
}

// 多态用法
Animal animal = new Dog();
animal.sound();  // 输出：汪汪
```

### 接口实现
```java
// 定义接口
interface Flyable {
    void fly();
}

// 实现接口
class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("鸟在飞");
    }
}
```

### Lambda表达式
```java
// 接收函数式接口
interface Operation {
    int calculate(int a, int b);
}

// Lambda实现
Operation add = (a, b) -> a + b;
int result = add.calculate(5, 3);  // 8
```

### 数组操作
```java
// 创建和遍历
int[] arr = {1, 2, 3, 4, 5};
for (int num : arr) {
    System.out.println(num);
}

// 排序和查找
Arrays.sort(arr);
int index = Arrays.binarySearch(arr, 3);
```

### 字符串处理
```java
String text = "Hello World";

// String方法
String upper = text.toUpperCase();        // 转大写
String[] words = text.split(" ");         // 分割
String replaced = text.replace("o", "0"); // 替换

// StringBuilder拼接（高效）
StringBuilder sb = new StringBuilder();
sb.append("Hello");
sb.append(" ");
sb.append("World");
String result = sb.toString();
```

---

## 🎯 学习目标

### 第4章目标
- [ ] 理解类的三要素：属性、方法、构造方法
- [ ] 掌握this和static的区别
- [ ] 能够创建和使用对象

### 第5章目标
- [ ] 掌握继承的语法和super的用法
- [ ] 理解多态的动态绑定机制
- [ ] 学会instanceof和向下转型
- [ ] 了解final的三种用法

### 第6章目标
- [ ] 理解抽象类的设计目的
- [ ] 掌握接口的定义和多接口实现
- [ ] 学会使用Lambda表达式
- [ ] 能够用接口设计系统

### 第7章目标
- [ ] 掌握数组的各种操作
- [ ] 理解String的不可变性
- [ ] 会使用StringBuilder优化字符串拼接
- [ ] 能够使用Math和Random进行计算和随机处理

---

**提示**：按照建议的学习顺序，逐个运行这些文件，修改代码进行实验，才能真正掌握这些知识点！
