/**
 * [多态练习] - Galgame 恋爱模拟
 *
 * 知识点：继承、多态、@Override
 *
 * 期望输出：
 *   ===== 第1天 =====
 *   雪乃 在教室安静地看书
 *   雪乃：今天天气真好呢...
 *
 *   ===== 第2天 =====
 *   理世 在学生会认真工作
 *   理世：有什么事吗？
 *
 *   ===== 第3天 =====
 *   小町 从转学第一天就元气满满
 *   小町：请多关照呀！
 *
 *   ===== 特殊事件 =====
 *   【雪乃路线】一起回家，触发共通结局
 *   【理世路线】被委派任务，触发学生会结局
 *   【小町路线】被卷入秘密计划，触发神秘结局
 */

public class GalgameSys {

    // ========== 父类：女主角 ==========
    static class Heroine {
        protected String name;
        protected int age;
        protected String properties;

        public Heroine(String name, int age, String properties) {
            this.name = name;
            this.age = age;
            this.properties = properties;
        }

        public void dailyEvent() {
            System.out.println(name + "做了某件事");
        }

        public void specialEvent() {
            System.out.println("【" + name + "路线】某个结局");
        }
    }

    // ========== 子类：青梅竹马 ==========
    static class ChildhoodFriend extends Heroine {
        public ChildhoodFriend(String name, int age, String properties) {
            super(name, age, properties);
        }

        @Override
        public void dailyEvent() {
            System.out.println(name + " 在教室安静地看书");
            System.out.println(name + "：今天天气真好呢...");
        }

        @Override
        public void specialEvent() {
            System.out.println("【" + name + "路线】一起回家，触发共通结局");
        }
    }

    // ========== 子类：学生会长 ==========
    static class StudentCouncil extends Heroine {
        public StudentCouncil(String name, int age, String properties) {
            super(name, age, properties);
        }

        @Override
        public void dailyEvent() {
            System.out.println(name + " 在学生会认真工作");
            System.out.println(name + "：有什么事吗？");
        }

        @Override
        public void specialEvent() {
            System.out.println("【" + name + "路线】被委派任务，触发学生会结局");
        }
    }

    // ========== 子类：转校生 ==========
    static class TransferStudent extends Heroine {
        public TransferStudent(String name, int age, String properties) {
            super(name, age, properties);
        }

        @Override
        public void dailyEvent() {
            System.out.println(name + " 从转学第一天就元气满满");
            System.out.println(name + "：请多关照呀！");
        }

        @Override
        public void specialEvent() {
            System.out.println("【" + name + "路线】被卷入秘密计划，触发神秘结局");
        }
    }

    // ========== 游戏系统 ==========
    static class GameSystem {
        public void dailyEvent(Heroine heroine) {
            heroine.dailyEvent();
        }

        public void specialEvent(Heroine heroine) {
            heroine.specialEvent();
        }
    }

    // ========== 主方法 ==========
    public static void main(String[] args) {
        Heroine yuki = new ChildhoodFriend("雪乃", 17, "安静");
        Heroine riko = new StudentCouncil("理世", 18, "学生会长");
        Heroine makoto = new TransferStudent("小町", 17, "谜之转校生");

        GameSystem game = new GameSystem();

        System.out.println("===== 第1天 =====");
        game.dailyEvent(yuki);

        System.out.println("\n===== 第2天 =====");
        game.dailyEvent(riko);

        System.out.println("\n===== 第3天 =====");
        game.dailyEvent(makoto);

        System.out.println("\n===== 特殊事件 =====");
        game.specialEvent(yuki);
        game.specialEvent(riko);
        game.specialEvent(makoto);
    }
}
