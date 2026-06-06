/**
 * 第12章 - AWT组件与Swing组件（GUI编程）
 *
 * 【核心概念】GUI = 图形用户界面，用窗口代替命令行
 *   AWT — 早期的GUI库，依赖操作系统，外观不统一
 *   Swing — AWT的升级版，纯Java实现，外观统一（推荐使用）
 *
 * 【常用组件】
 *   JFrame   — 窗口（顶层容器）
 *   JPanel   — 面板（中间容器，用来组织组件）
 *   JLabel   — 标签（显示文字/图片）
 *   JButton  — 按钮
 *   JTextField — 文本输入框
 *   JTextArea — 多行文本区
 *
 * 【布局管理】
 *   FlowLayout  — 流式布局（从左到右，一行放不下就换行）
 *   BorderLayout — 边界布局（上下左右中）
 *   GridLayout   — 网格布局（格子）
 *
 * 【事件处理】
 *   按钮点击：addActionListener + lambda表达式
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Chapter12Application {
    public static void main(String[] args) {
        System.out.println("========== 12.1 简单窗口 ==========\n");

        // 创建窗口
        JFrame frame = new JFrame("Galgame 角色管理");
        frame.setSize(400, 300);  // 窗口大小
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 关闭窗口时退出程序
        frame.setLocationRelativeTo(null);  // 居中显示

        // 添加标签
        JLabel label = new JLabel("欢迎来到角色管理系统", SwingConstants.CENTER);
        label.setFont(new Font("微软雅黑", Font.BOLD, 16));
        frame.add(label);

        // 显示窗口
        frame.setVisible(true);

        System.out.println("窗口已显示（关闭窗口结束程序）");
        System.out.println("如果窗口无法打开，继续执行后面的示例...\n");

        System.out.println("========== 12.2 按钮事件 ==========\n");

        // 事件处理示例（在控制台模拟）
        String[] characters = {"雪乃", "理世", "小町"};
        int[] affection = {85, 70, 90};

        System.out.println("点击按钮查看角色信息：");
        for (int i = 0; i < characters.length; i++) {
            System.out.println("  按钮" + (i + 1) + ": " + characters[i] + " (好感度: " + affection[i] + ")");
        }

        System.out.println("\n========== 12.3 布局管理 ==========\n");

        System.out.println("FlowLayout（流式布局）：组件从左到右排列");
        System.out.println("  [按钮1] [按钮2] [按钮3]");
        System.out.println("  [按钮4] [按钮5]");

        System.out.println("\nBorderLayout（边界布局）：");
        System.out.println("  ┌─────────────────┐");
        System.out.println("  │      上边        │");
        System.out.println("  ├────┬─────┬──────┤");
        System.out.println("  │左  │ 中间 │  右   │");
        System.out.println("  ├────┴─────┴──────┤");
        System.out.println("  │      下边        │");
        System.out.println("  └─────────────────┘");

        System.out.println("\nGridLayout（网格布局）：均匀分成格子");
        System.out.println("  ┌───┬───┬───┐");
        System.out.println("  │ 1 │ 2 │ 3 │");
        System.out.println("  ├───┼───┼───┤");
        System.out.println("  │ 4 │ 5 │ 6 │");
        System.out.println("  └───┴───┴───┘");

        System.out.println("\n========== 12.4 综合示例代码说明 ==========\n");

        System.out.println("完整GUI程序的典型结构：");
        System.out.println("1. 创建 JFrame 窗口");
        System.out.println("2. 设置布局管理器");
        System.out.println("3. 创建组件（JLabel, JButton, JTextField 等）");
        System.out.println("4. 将组件添加到窗口或面板");
        System.out.println("5. 注册事件监听器（按钮点击、键盘输入等）");
        System.out.println("6. 设置窗口可见 setVisible(true)");
    }
}
