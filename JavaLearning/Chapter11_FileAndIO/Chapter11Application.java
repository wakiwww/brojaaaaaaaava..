/**
 * 第11章 - File类及I/O操作
 *
 * 【核心概念】I/O = 输入输出，程序与外部资源（文件、网络）之间的数据传输
 *   输入流（InputStream/Reader）：从外部读数据到程序
 *   输出流（OutputStream/Writer）：从程序写数据到外部
 *
 * 【流的分类】
 *   字节流：处理任意文件（图片、视频、音频）
 *   字符流：处理文本文件（更方便，自动处理编码）
 *
 * 【常用类】
 *   File           — 文件/目录的操作（创建、删除、判断）
 *   FileInputStream/OutputStream — 字节流读写
 *   FileReader/FileWriter       — 字符流读写
 *   BufferedReader/BufferedWriter — 带缓冲的字符流（更高效）
 *   PrintWriter  — 便捷的输出流（自动换行）
 */

import java.io.*;

public class Chapter11Application {
    public static void main(String[] args) {
        System.out.println("========== 11.1 File 类 ==========\n");

        // File 类用于操作文件和目录
        File file = new File("test.txt");

        // 创建文件
        try {
            if (file.createNewFile()) {
                System.out.println("文件创建成功: " + file.getName());
            } else {
                System.out.println("文件已存在");
            }
        } catch (IOException e) {
            System.out.println("创建文件失败: " + e.getMessage());
        }

        // 文件信息
        System.out.println("绝对路径: " + file.getAbsolutePath());
        System.out.println("文件大小: " + file.length() + " 字节");
        System.out.println("是否存在: " + file.exists());
        System.out.println("是否是文件: " + file.isFile());
        System.out.println("是否是目录: " + file.isDirectory());

        // 创建目录
        File dir = new File("test_dir");
        if (dir.mkdir()) {
            System.out.println("目录创建成功");
        }

        System.out.println("\n========== 11.2 字节流读写 ==========\n");

        // FileOutputStream — 写入字节
        try (FileOutputStream fos = new FileOutputStream("test.txt")) {
            String content = "Hello, Java I/O!";
            fos.write(content.getBytes());  // 字符串转字节数组
            System.out.println("写入成功");
        } catch (IOException e) {
            System.out.println("写入失败: " + e.getMessage());
        }

        // FileInputStream — 读取字节
        try (FileInputStream fis = new FileInputStream("test.txt")) {
            byte[] buffer = new byte[1024];
            int length = fis.read(buffer);
            String content = new String(buffer, 0, length);
            System.out.println("读取内容: " + content);
        } catch (IOException e) {
            System.out.println("读取失败: " + e.getMessage());
        }

        System.out.println("\n========== 11.3 字符流读写 ==========\n");

        // FileWriter — 写入字符（文本专用）
        try (FileWriter fw = new FileWriter("test_chars.txt")) {
            fw.write("第一行：雪乃好感度 85\n");
            fw.write("第二行：理世好感度 70\n");
            fw.write("第三行：小町好感度 90\n");
            System.out.println("字符写入成功");
        } catch (IOException e) {
            System.out.println("写入失败: " + e.getMessage());
        }

        // FileReader — 读取字符
        try (FileReader fr = new FileReader("test_chars.txt")) {
            char[] buffer = new char[1024];
            int length = fr.read(buffer);
            String content = new String(buffer, 0, length);
            System.out.println("读取内容:\n" + content);
        } catch (IOException e) {
            System.out.println("读取失败: " + e.getMessage());
        }

        System.out.println("========== 11.4 缓冲流读写 ==========\n");

        // BufferedWriter — 高效写入
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("test_buffered.txt"))) {
            bw.write("缓冲写入第一行");
            bw.newLine();  // 换行
            bw.write("缓冲写入第二行");
            bw.newLine();
            bw.write("缓冲写入第三行");
            System.out.println("缓冲写入成功");
        } catch (IOException e) {
            System.out.println("写入失败: " + e.getMessage());
        }

        // BufferedReader — 高效读取，按行读
        try (BufferedReader br = new BufferedReader(new FileReader("test_buffered.txt"))) {
            String line;
            System.out.println("按行读取:");
            while ((line = br.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            System.out.println("读取失败: " + e.getMessage());
        }

        System.out.println("\n========== 11.5 PrintWriter ==========\n");

        // PrintWriter — 最方便的输出流
        try (PrintWriter pw = new PrintWriter("test_print.txt")) {
            pw.println("姓名: 雪乃");
            pw.println("年龄: 17");
            pw.println("好感度: 85");
            System.out.println("PrintWriter 写入成功");
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到: " + e.getMessage());
        }

        // 读取验证
        try (BufferedReader br = new BufferedReader(new FileReader("test_print.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("读取失败: " + e.getMessage());
        }

        // 清理测试文件
        System.out.println("\n========== 清理测试文件 ==========");
        cleanupFile("test.txt");
        cleanupFile("test_chars.txt");
        cleanupFile("test_buffered.txt");
        cleanupFile("test_print.txt");
        cleanupDir("test_dir");
    }

    public static void cleanupFile(String filename) {
        File f = new File(filename);
        if (f.delete()) {
            System.out.println("已删除: " + filename);
        }
    }

    public static void cleanupDir(String dirname) {
        File d = new File(dirname);
        if (d.delete()) {
            System.out.println("已删除目录: " + dirname);
        }
    }
}
