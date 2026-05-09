/**
 * 第7章 - 7.3 字符串类（String、StringBuilder、StringBuffer）
 *
 * 【String —— 不可变】
 *   每次修改（拼接、替换）都会创建新的 String 对象，原对象不变
 *   String s = "Hello"; s += "World"; → 原来的 "Hello" 还在内存里，s 指向了新的 "HelloWorld"
 *   适合：字符串不经常变化的场景
 *
 * 【StringBuilder —— 可变，非线程安全】
 *   在原对象上直接修改，不会创建新对象，性能更好
 *   适合：单线程中频繁拼接、修改字符串
 *
 * 【StringBuffer —— 可变，线程安全】
 *   和 StringBuilder 用法一样，但方法加了 synchronized，多线程安全
 *   适合：多线程环境（实际开发中较少用）
 *
 * 【== vs equals()】
 *   == 比较的是引用（是否同一个对象）
 *   equals() 比较的是内容（值是否相同）
 *   字符串比较永远用 equals()，不要用 ==
 */

public class StringAndBuilders {

    // ========== String 类 ==========
    static class StringDemo {
        public static void main(String[] args) {
            System.out.println("=== String类演示 ===\n");

            // 1. String 的创建方式
            String str1 = "Hello";              // 字面量 → 存在字符串常量池
            String str2 = new String("Hello");   // new → 存在堆内存（新对象）
            String str3 = "Hello";              // 和 str1 指向常量池中同一个对象

            // == 比较的是引用（内存地址）
            System.out.println("str1 == str3: " + (str1 == str3));      // true（同一个常量池对象）
            System.out.println("str1 == str2: " + (str1 == str2));      // false（不同对象）
            // equals() 比较的是内容
            System.out.println("str1.equals(str2): " + str1.equals(str2)); // true（内容相同）

            // 2. 常用方法
            String text = "  Java Programming  ";
            System.out.println("原始字符串: [" + text + "]");
            System.out.println("去除空格: [" + text.trim() + "]");       // 去掉首尾空格
            System.out.println("长度: " + text.length());               // 字符个数（含空格）
            System.out.println("转大写: " + text.toUpperCase());
            System.out.println("转小写: " + text.toLowerCase());

            // 3. 截取 substring(开始索引, 结束索引)
            // 注意：包含开始，不包含结束 [start, end)
            String sentence = "Hello World Java";
            System.out.println("从索引6开始: " + sentence.substring(6));      // "World Java"
            System.out.println("从6到11: " + sentence.substring(6, 11));     // "World"

            // 4. 分割 split：按指定分隔符拆分成数组
            String[] words = sentence.split(" ");
            System.out.println("分割后:");
            for (String word : words) {
                System.out.println("  " + word);
            }

            // 5. 替换 replace：返回新字符串，原字符串不变
            String replaced = sentence.replace("Java", "Python");
            System.out.println("替换后: " + replaced);

            // 6. 查找 indexOf：返回第一次出现的索引，找不到返回 -1
            int index = sentence.indexOf("World");
            System.out.println("'World'的位置: " + index);
        }
    }

    // ========== StringBuilder 类 ==========
    static class StringBuilderDemo {
        public static void main(String[] args) {
            System.out.println("\n=== StringBuilder演示 ===\n");

            StringBuilder sb = new StringBuilder();

            // 1. append：在末尾追加（直接修改原对象，不会创建新对象）
            sb.append("Hello ");
            sb.append("World ");
            sb.append("Java");
            System.out.println("追加后: " + sb.toString());

            // 2. insert：在指定位置插入
            sb.insert(6, "Beautiful ");  // 在索引6的位置插入
            System.out.println("插入后: " + sb.toString());

            // 3. delete：删除指定范围 [start, end)
            sb.delete(6, 16);  // 删除 "Beautiful "
            System.out.println("删除后: " + sb.toString());

            // 4. reverse：反转
            sb.reverse();
            System.out.println("反转后: " + sb.toString());

            // 5. length 和 capacity
            // length = 实际字符数，capacity = 内部数组容量（自动扩容）
            System.out.println("长度: " + sb.length());
            System.out.println("容量: " + sb.capacity());

            // ========== 性能对比：String 拼接 vs StringBuilder ==========
            System.out.println("\n--- 性能对比 ---");

            // String 拼接：每次 += 都创建新对象，1000次循环创建1000个废弃对象 → 慢
            long start = System.currentTimeMillis();
            String result = "";
            for (int i = 0; i < 1000; i++) {
                result += i + ",";
            }
            long stringTime = System.currentTimeMillis() - start;

            // StringBuilder：在同一个对象上操作，不会创建新对象 → 快
            start = System.currentTimeMillis();
            StringBuilder result2 = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                result2.append(i).append(",");
            }
            long builderTime = System.currentTimeMillis() - start;

            System.out.println("String连接耗时: " + stringTime + "ms");
            System.out.println("StringBuilder耗时: " + builderTime + "ms");
        }
    }

    // ========== StringBuffer 类 ==========
    // 用法和 StringBuilder 完全一样，区别是线程安全（方法加了 synchronized）
    static class StringBufferDemo {
        public static void main(String[] args) {
            System.out.println("\n=== StringBuffer演示 ===\n");

            StringBuffer buffer = new StringBuffer("Hello");
            buffer.append(" World");
            System.out.println("追加后: " + buffer.toString());

            buffer.insert(5, " Beautiful");
            System.out.println("插入后: " + buffer.toString());

            buffer.reverse();
            System.out.println("反转后: " + buffer.toString());

            System.out.println("StringBuffer线程安全，适合多线程环境");
        }
    }

    public static void main(String[] args) {
        StringDemo.main(args);
        StringBuilderDemo.main(args);
        StringBufferDemo.main(args);
    }
}
