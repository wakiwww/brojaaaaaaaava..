/**
 * 第4章 综合应用 - 学生管理系统
 * 应用场景：综合运用类、对象、构造方法、this、static等知识
 */

class Student {
    // 实例变量 - 每个学生对象独有
    private String studentId;
    private String name;
    private int age;
    private double gpa;

    // 类变量 - 所有学生共享
    private static int totalStudents = 0;
    private static String school = "计算机学院";

    // 构造方法1 - 完整初始化
    public Student(String studentId, String name, int age, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        totalStudents++;
    }

    // 构造方法2 - 部分初始化，调用其他构造方法（构造方法重载）
    public Student(String name, int age) {
        this("S" + (totalStudents + 1), name, age, 0.0);
    }

    // 实例方法 - 计算学分绩点等级
    public String getGradeLevel() {
        if (gpa >= 3.8) return "A+";
        if (gpa >= 3.5) return "A";
        if (gpa >= 3.0) return "B+";
        if (gpa >= 2.5) return "B";
        return "C";
    }

    // 实例方法 - 显示学生信息，使用this
    public void displayInfo() {
        System.out.println("===学生信息===");
        System.out.println("学号: " + this.studentId);
        System.out.println("姓名: " + this.name);
        System.out.println("年龄: " + this.age);
        System.out.println("GPA: " + this.gpa + " (" + this.getGradeLevel() + ")");
        System.out.println("学院: " + Student.school);
        System.out.println("当前学院学生总数: " + Student.totalStudents);
    }

    // 静态方法 - 显示班级整体信息
    public static void displayClassInfo() {
        System.out.println("\n===班级统计信息===");
        System.out.println("学院: " + school);
        System.out.println("学生总数: " + totalStudents);
    }

    // 静态方法 - 设置学院名称
    public static void setSchool(String schoolName) {
        Student.school = schoolName;
    }

    // getter和setter
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    public static int getTotalStudents() { return totalStudents; }
}
