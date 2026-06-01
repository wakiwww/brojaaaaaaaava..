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
            System.out.println(name + "は何もしていない");
        }

        public void specialEvent() {
            System.out.println("【" + name + "ルート】あるエンディング");
        }
    }

    // ========== 子类：青梅竹马，可以触发回忆事件 ==========
    static class ChildhoodFriend extends Heroine {
        public ChildhoodFriend(String name, int age, String properties) {
            super(name, age, properties);
        }

        @Override
        public void dailyEvent() {
            System.out.println(name + "は教室で静かに本を読んでいます");
            System.out.println(name + "：今日はいい天気ですね...");
        }

        @Override
        public void specialEvent() {
            System.out.println("【" + name + "ルート】一緒に帰る、共通ルート");
        }

        public void triggerMemory(){
            System.out.println("【"+name+"】回想イベント発動：あの頃、あなただったなんて！");
        }
    }

    // ========== 子类：学生会长 ==========
    static class StudentCouncil extends Heroine {
        public StudentCouncil(String name, int age, String properties) {
            super(name, age, properties);
        }

        @Override
        public void dailyEvent() {
            System.out.println(name + "は生徒会で真面目に働いています");
            System.out.println(name + "：何か用がありますか？");
        }

        @Override
        public void specialEvent() {
            System.out.println("【" + name + "ルート】任務を受ける、生徒会ルート");
        }
        public void triggerWorkInvite(){
            System.out.println("【"+name+"】仕事の誘い発動：文化祭、一緒に準備しませんか？");
        }
    }

    // ========== 子类：转校生 ==========
    static class TransferStudent extends Heroine {
        public TransferStudent(String name, int age, String properties) {
            super(name, age, properties);
        }

        @Override
        public void dailyEvent() {
            System.out.println(name + "は転校初日から元気いっぱい");
            System.out.println(name + "：よろしくお願いします！");
        }

        @Override
        public void specialEvent() {
            System.out.println("【" + name + "ルート】秘密に巻き込まれる、ミステリールート");
        }

        public void triggerMystery(){
            System.out.println("【"+name+"】身元の謎発動：実は、私は未来から来たの...");
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
// 处理不同类对应的情况
        public void triggerSpecial(Heroine heroine){
            if(heroine instanceof ChildhoodFriend){
                ((ChildhoodFriend)heroine).triggerMemory();
            } else if(heroine instanceof StudentCouncil){
                ((StudentCouncil)heroine).triggerWorkInvite();
            } else if(heroine instanceof TransferStudent){
                ((TransferStudent)heroine).triggerMystery();
            }
        }
    }

    // ========== 主方法 ==========
    public static void main(String[] args) {
        Heroine yuki = new ChildhoodFriend("yukino", 17, "安静");
        Heroine riko = new StudentCouncil("riko", 18, "学生会长");
        Heroine makoto = new TransferStudent("makoto", 17, "谜之转校生");

        GameSystem game = new GameSystem();

        System.out.println("===== 1日目 =====");
        game.dailyEvent(yuki);

        System.out.println("\n===== 2日目 =====");
        game.dailyEvent(riko);

        System.out.println("\n===== 3日目 =====");
        game.dailyEvent(makoto);

        System.out.println("\n===== 特殊イベント =====");
        game.specialEvent(yuki);
        game.specialEvent(riko);
        game.specialEvent(makoto);

        System.out.println("\n===== 好感度システム =====");
        game.triggerSpecial(yuki);
        game.triggerSpecial(riko);
        game.triggerSpecial(makoto);
    }
}

// =====================================================================
// 第二题：好感度系统（需要 instanceof + 向下转型）
// =====================================================================
/**
 * 多态练习2 - Galgame 好感度系统
 *
 * 知识点：多态、instanceof、向下转型
 *
 * 任务：在上面的基础上，给 GameSystem 新增一个 triggerSpecial 方法。
 *       传入任意女主角，判断类型后调用该角色独有的事件方法。
 *
 * 子类特有方法（父类没有）：
 *   青梅竹马 → triggerMemory()
 *   子生会长 → triggerWorkInvite()
 *   转校生   → triggerMystery()
 *
 * 期望输出（在 main 里调用 game.triggerSpecial 后）：
 *   === 好感度系统 ===
 *   【雪乃】触发回忆事件：原来我们小时候就见过！
 *   【理世】触发工作邀请：一起准备文化祭吧！
 *   【小町】触发身世之谜：其实我是从未来来的...
 */
