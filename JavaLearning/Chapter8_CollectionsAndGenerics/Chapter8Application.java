/**
 * 第8章 - 集合类与泛型
 *
 * 【核心概念】集合 = 动态数组，大小可变，提供丰富操作方法
 *   数组：固定长度，只能存同一种类型
 *   集合：动态增长，提供增删改查等丰富方法
 *
 * 【三大接口】
 *   List  — 有序、可重复（像排队，有顺序，可以插队）
 *   Set   — 无序、不可重复（像进考场，不能重名）
 *   Map   — 键值对（像字典，用单词查释义）
 *
 * 【常用实现类】
 *   List → ArrayList（数组实现，查询快）、LinkedList（链表实现，增删快）
 *   Set  → HashSet（无序去重）、TreeSet（排序去重）
 *   Map  → HashMap（无序）、TreeMap（排序）
 */

import java.util.*;

public class Chapter8Application {
    public static void main(String[] args) {
        System.out.println("========== 8.1 List 接口 ==========\n");

        // ArrayList — 数组实现，查询快
        ArrayList<String> names = new ArrayList<>();
        names.add("雪乃");
        names.add("理世");
        names.add("小町");
        names.add("雪乃");  // 可以重复

        System.out.println("names: " + names);
        System.out.println("大小: " + names.size());
        System.out.println("第1个: " + names.get(0));
        System.out.println("是否包含雪乃: " + names.contains("雪乃"));

        names.remove("理世");  // 按值删除
        System.out.println("删除理世后: " + names);

        names.set(0, "新雪乃");  // 修改
        System.out.println("修改后: " + names);

        System.out.println("\n========== 8.2 Set 接口 ==========\n");

        // HashSet — 无序去重
        HashSet<String> courses = new HashSet<>();
        courses.add("Java");
        courses.add("Python");
        courses.add("Java");  // 重复，不会被加入
        courses.add("C++");

        System.out.println("courses: " + courses);
        System.out.println("大小: " + courses.size());  // 3，不是4

        // TreeSet — 自动排序
        TreeSet<Integer> scores = new TreeSet<>();
        scores.add(85);
        scores.add(60);
        scores.add(92);
        scores.add(73);

        System.out.println("排序后: " + scores);  // [60, 73, 85, 92]

        System.out.println("\n========== 8.3 Map 接口 ==========\n");

        // HashMap — 键值对
        HashMap<String, Integer> affection = new HashMap<>();
        affection.put("雪乃", 85);
        affection.put("理世", 70);
        affection.put("小町", 90);

        System.out.println("好感度: " + affection);
        System.out.println("雪乃好感度: " + affection.get("雪乃"));
        System.out.containsKey("雪乃");
        affection.put("雪乃", 95);  // 覆盖旧值
        System.out.println("雪乃好感度(更新后): " + affection.get("雪乃"));

        System.out.println("\n========== 8.4 遍历集合 ==========\n");

        // for-each 遍历
        System.out.print("List遍历: ");
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();

        // Iterator 遍历
        System.out.print("Set遍历: ");
        Iterator<String> it = courses.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // Map 遍历
        System.out.println("Map遍历:");
        for (Map.Entry<String, Integer> entry : affection.entrySet()) {
            System.out.println("  " + entry.getKey() + " → " + entry.getValue());
        }

        System.out.println("\n========== 8.5 泛型 ==========\n");

        // 泛型 = 在定义集合时指定类型，编译时检查，避免类型错误
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        // numbers.add("hello");  // ❌ 编译报错！泛型不允许放字符串

        System.out.println("数字列表: " + numbers);

        // 自定义泛型类
        System.out.println("通用容器测试:");
        Box<String> strBox = new Box<>();
        strBox.setItem("Hello");
        System.out.println("字符串盒子: " + strBox.getItem());

        Box<Integer> intBox = new Box<>();
        intBox.setItem(123);
        System.out.println("整数盒子: " + intBox.getItem());
    }
}

// 自定义泛型类
class Box<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
