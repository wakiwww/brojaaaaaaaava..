/**
 * 第7章 综合应用 - 学生成绩管理系统
 * 知识点：综合运用数组、String、Math、Object等
 */

public class Student {
    private String studentId;
    private String name;
    private int[] scores;  // 多次成绩

    public Student(String studentId, String name, int[] scores) {
        this.studentId = studentId;
        this.name = name;
        this.scores = scores.clone();  // 深拷贝
    }

    // 获取平均成绩
    public double getAverageScore() {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }

    // 获取最高成绩
    public int getHighestScore() {
        int max = scores[0];
        for (int score : scores) {
            max = Math.max(max, score);
        }
        return max;
    }

    // 获取最低成绩
    public int getLowestScore() {
        int min = scores[0];
        for (int score : scores) {
            min = Math.min(min, score);
        }
        return min;
    }

    // 获取成绩等级
    public String getGrade() {
        double avg = getAverageScore();
        if (avg >= 90) return "A";
        if (avg >= 80) return "B";
        if (avg >= 70) return "C";
        if (avg >= 60) return "D";
        return "F";
    }

    // 重写toString方法
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("学号: ").append(studentId).append("\n");
        sb.append("姓名: ").append(name).append("\n");
        sb.append("成绩: ").append(java.util.Arrays.toString(scores)).append("\n");
        sb.append("平均分: ").append(String.format("%.2f", getAverageScore())).append("\n");
        sb.append("等级: ").append(getGrade()).append("\n");
        return sb.toString();
    }

    // 重写equals方法
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;

        Student other = (Student) obj;
        return studentId.equals(other.studentId);
    }

    // getter
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public int[] getScores() { return scores; }
}

// 成绩管理系统
class GradeManagementSystem {
    private java.util.List<Student> students = new java.util.ArrayList<>();

    // 添加学生
    public void addStudent(Student student) {
        students.add(student);
    }

    // 显示所有学生
    public void displayAllStudents() {
        System.out.println("========== 所有学生信息 ==========");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // 计算班级平均分
    public double getClassAverage() {
        if (students.isEmpty()) return 0;

        double total = 0;
        for (Student student : students) {
            total += student.getAverageScore();
        }
        return total / students.size();
    }

    // 找到最高分学生
    public Student getTopStudent() {
        if (students.isEmpty()) return null;

        Student top = students.get(0);
        for (Student student : students) {
            if (student.getAverageScore() > top.getAverageScore()) {
                top = student;
            }
        }
        return top;
    }

    // 按成绩排序（降序）
    public void sortByScore() {
        students.sort((s1, s2) -> Double.compare(s2.getAverageScore(), s1.getAverageScore()));
    }

    // 按名字排序
    public void sortByName() {
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
    }

    // 统计各等级的学生数
    public void displayGradeStatistics() {
        System.out.println("\n========== 等级统计 ==========");

        int[] counts = new int[5];  // A, B, C, D, F
        java.util.Map<String, Integer> gradeCount = new java.util.HashMap<>();
        gradeCount.put("A", 0);
        gradeCount.put("B", 0);
        gradeCount.put("C", 0);
        gradeCount.put("D", 0);
        gradeCount.put("F", 0);

        for (Student student : students) {
            String grade = student.getGrade();
            gradeCount.put(grade, gradeCount.get(grade) + 1);
        }

        gradeCount.forEach((grade, count) ->
            System.out.println("等级 " + grade + ": " + count + " 人")
        );
    }

    // 显示统计信息
    public void displayStatistics() {
        System.out.println("\n========== 班级统计信息 ==========");
        System.out.println("学生总数: " + students.size());
        System.out.println("班级平均分: " + String.format("%.2f", getClassAverage()));

        Student top = getTopStudent();
        if (top != null) {
            System.out.println("最高分学生: " + top.getName() +
                             " (" + String.format("%.2f", top.getAverageScore()) + ")");
        }
    }
}

// 演示程序
class Chapter7Application {
    public static void main(String[] args) {
        System.out.println("=== 学生成绩管理系统 ===\n");

        // 创建管理系统
        GradeManagementSystem system = new GradeManagementSystem();

        // 添加学生（使用随机成绩生成）
        java.util.Random random = new java.util.Random(123);  // 固定种子以保证结果一致

        String[] names = {"张三", "李四", "王五", "赵六", "孙七"};
        for (int i = 0; i < names.length; i++) {
            int[] scores = new int[5];
            for (int j = 0; j < scores.length; j++) {
                scores[j] = 60 + random.nextInt(41);  // 60-100分
            }
            system.addStudent(new Student("S" + (i + 1), names[i], scores));
        }

        // 显示所有学生信息
        system.displayAllStudents();

        // 显示统计信息
        system.displayStatistics();
        system.displayGradeStatistics();

        // 按成绩排序并显示
        System.out.println("\n========== 按成绩排序（降序）==========");
        system.sortByScore();
        for (Student student : system.students) {
            System.out.println(student.getName() + ": " +
                             String.format("%.2f", student.getAverageScore()));
        }

        // 按名字排序并显示
        System.out.println("\n========== 按名字排序 ==========");
        system.sortByName();
        for (Student student : system.students) {
            System.out.println(student.getName());
        }
    }
}
