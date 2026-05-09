# Java学习项目 - JavaLearning

根据《Java程序设计基础项目实战》从第4章开始，创建的系统化Java学习资源。

## 项目结构

```
JavaLearning/
├── Chapter4_ClassesAndObjects/        # 第4章：类和对象
├── Chapter5_InheritanceAndPolymorphism/   # 第5章：继承与多态
├── Chapter6_AbstractAndInterface/     # 第6章：抽象类与接口
└── Chapter7_ArraysAndCommonClasses/   # 第7章：数组与常用类
```

## 学习指南

### 第4章：类和对象 (Classes and Objects)

**核心概念**：面向对象编程的基础

| 文件 | 内容 | 学习重点 |
|------|------|--------|
| `BasicClass.java` | 基本类定义 | 属性、方法、getter/setter |
| `ObjectCreation.java` | 对象创建与使用 | 构造方法（无参/有参）、new关键字 |
| `ThisAndStaticDemo.java` | this和static关键字 | 实例变量与类变量的区别 |
| `Chapter4Application.java` | 学生管理系统 | 综合应用：构造方法重载、this使用 |
| `Chapter4Test.java` | 测试和演示 | 完整的演示程序 |

**运行方式**：
```bash
javac Chapter4Test.java
java Chapter4Test
```

**关键知识点**：
- ✅ 类的三大要素：属性、方法、构造方法
- ✅ this关键字代表当前对象
- ✅ static修饰的成员属于类，被所有对象共享
- ✅ 构造方法的重载

---

### 第5章：继承与多态 (Inheritance & Polymorphism)

**核心概念**：代码复用和多种形态

| 文件 | 内容 | 学习重点 |
|------|------|--------|
| `BasicInheritance.java` | 继承的基础 | extends关键字、方法重写、super关键字 |
| `Polymorphism.java` | 多态演示 | 父类引用→子类对象、动态绑定 |
| `FinalKeyword.java` | final关键字 | final类、final方法、final变量 |
| `Chapter5Application.java` | 员工管理系统 | 多层继承、多态应用、instanceof操作符 |

**运行方式**：
```bash
javac Polymorphism.java
java Polymorphism.Polymorphism

javac Chapter5Application.java
java Chapter5Application.Chapter5Application
```

**关键知识点**：
- ✅ 继承的语法：`extends`
- ✅ 方法重写（Override）
- ✅ 多态的三个条件：继承、重写、向上转型
- ✅ instanceof操作符和向下转型
- ✅ final修饰符的三种用法

---

### 第6章：抽象类与接口 (Abstract Classes & Interfaces)

**核心概念**：定义规范和契约

| 文件 | 内容 | 学习重点 |
|------|------|--------|
| `AbstractClass.java` | 抽象类 | abstract关键字、抽象方法、模板方法 |
| `Interface.java` | 接口 | interface关键字、implements、多接口实现 |
| `LambdaExpression.java` | Lambda表达式 | 函数式编程、@FunctionalInterface |
| `Chapter6Application.java` | 支付系统 | 接口+抽象类+Lambda的综合应用 |

**运行方式**：
```bash
javac AbstractClass.java
java AbstractClass.AbstractClassDemo

javac Interface.java
java Interface.InterfaceDemo

javac LambdaExpression.java
java LambdaExpression.LambdaDemo

javac Chapter6Application.java
java Chapter6Application.Chapter6Application
```

**关键知识点**：
- ✅ 抽象类的定义和用途
- ✅ 接口与抽象类的区别
- ✅ 一个类实现多个接口
- ✅ 函数式接口和Lambda表达式
- ✅ Lambda的三种形式：参数→结果、代码块、方法引用

---

### 第7章：数组与常用类 (Arrays & Common Classes)

**核心概念**：集合处理和内置工具类

| 文件 | 内容 | 学习重点 |
|------|------|--------|
| `ArrayBasics.java` | 数组基础 | 一维/二维数组、排序、搜索、复制 |
| `StringAndBuilders.java` | 字符串类 | String、StringBuilder、StringBuffer |
| `ObjectAndUtilityClasses.java` | Object/Math/Random | equals、hashCode、Math常用方法 |
| `Chapter7Application.java` | 成绩管理系统 | 数组、String、Math的综合应用 |

**运行方式**：
```bash
javac ArrayBasics.java
java ArrayBasics.ArrayBasics

javac StringAndBuilders.java
java StringAndBuilders.StringAndBuilders

javac ObjectAndUtilityClasses.java
java ObjectAndUtilityClasses.ObjectAndUtilityClasses

javac Chapter7Application.java
java Chapter7Application.Chapter7Application
```

**关键知识点**：
- ✅ 数组的声明、初始化、遍历
- ✅ Arrays工具类的常用方法
- ✅ String的不可变性
- ✅ StringBuilder和StringBuffer的区别
- ✅ Object类的三大方法：equals、hashCode、toString
- ✅ Math类的数学运算
- ✅ Random类生成随机数

---

## 学习建议

### 循序渐进的学习路径

1. **基础阶段**（第4章）
   - 先学习`BasicClass.java`理解类的结构
   - 再学`ObjectCreation.java`掌握对象创建
   - 最后学`ThisAndStaticDemo.java`区分实例和类成员

2. **继承阶段**（第5章）
   - `BasicInheritance.java`学习继承机制
   - `Polymorphism.java`理解多态的动态绑定
   - `Chapter5Application.java`看实际应用

3. **高级特性阶段**（第6章）
   - `AbstractClass.java`学习抽象的概念
   - `Interface.java`学习接口的定义和实现
   - `LambdaExpression.java`学习现代Java写法

4. **应用工具阶段**（第7章）
   - `ArrayBasics.java`掌握数组操作
   - `StringAndBuilders.java`理解字符串处理
   - 综合应用项目强化理解

### 代码运行与调试

**编译所有文件**：
```bash
javac Chapter*/*.java
```

**运行测试类**：
```bash
java Chapter4_ClassesAndObjects.Chapter4Test
java Chapter5_InheritanceAndPolymorphism.Chapter5Application
java Chapter6_AbstractAndInterface.Chapter6Application
java Chapter7_ArraysAndCommonClasses.Chapter7Application
```

### 实践项目

每章都包含一个综合应用项目：
- **第4章**：学生管理系统基础版
- **第5章**：员工管理系统（多层继承）
- **第6章**：支付系统（接口+设计模式）
- **第7章**：成绩管理系统（数据处理）

---

## 常见问题

**Q: 为什么String连接要用StringBuilder？**
A: String是不可变的，每次连接都会创建新对象。StringBuilder可以直接修改，效率高100倍。

**Q: 抽象类和接口有什么区别？**
A: 抽象类是is-a关系，接口是can-do关系。一个类只能继承一个抽象类，但可以实现多个接口。

**Q: Lambda表达式有什么优势？**
A: 代码更简洁，适合函数式编程。特别是在集合操作（stream、forEach）中非常实用。

**Q: 什么时候用static成员？**
A: 当某个属性或方法属于整个类而不是单个对象时使用，例如计数器、常量等。

---

## 拓展学习

完成第7章后，建议学习：
- 第8章：常用类库（包装类、日期）
- 第9章：集合框架（ArrayList、HashMap等）
- 第10章：异常处理
- 第11章：文件IO操作

---

**学习建议**：边看代码边运行，多修改代码进行实验，理解底层逻辑而不只是记住语法！
