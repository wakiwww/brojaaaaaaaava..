/**
 * 抽象类练习 - Galgame 路线事件
 *
 * 知识点：abstract 类、abstract 方法、构造方法、多态
 *
 * 背景：每个女主角有自己的路线事件，流程相同（显示标题→触发→显示对话），
 *       但每一步的具体内容不同。用抽象类当模板。
 *
 * 任务：补全抽象类 RouteEvent 和三个子类，使 main 方法输出与期望一致。
 *
 * 期望输出：
 *   ═══════════════════════════════
 *   ◆ 第1幕：告白
 *   ─────────────────────────────
 *   雪乃は顔を赤らめながら...
 *   「...ずっと好きでした」
 *   好感度: 85
 *   ═══════════════════════════════
 *
 *   ═══════════════════════════════
 *   ◆ 第2幕：文化祭
 *   ─────────────────────────────
 *   理世は文化祭の準備に追われている...
 *   「手伝ってくれてありがとう」
 *   好感度: 70
 *   ═══════════════════════════════
 *
 *   ═══════════════════════════════
 *   ◆ 第3幕：离别
 *   ─────────────────────────────
 *   小町は空港に立っている...
 *   「また会えるよね？」
 *   好感度: 90
 *   ═══════════════════════════════
 */

// ========== 抽象类：路线事件 ==========
// TODO：abstract 类，定义事件模板
//   - 属性：eventName（事件名）、affection（好感度）
//   - 构造方法初始化这两个属性
//   - abstract 方法：trigger()、getDialogue()
//   - 普通方法：displayHeader()，输出分隔线和事件标题
//   - 普通方法：showResult()，输出对话和好感度
abstract class route{
    protected String eventName;
    protected double affection;

    abstract void trigger();
    abstract String getDialogue();

    protected void displayHeader(){
        System.out.println("---------");
        System.out.print(eventName);
    }
}
// ========== 子类：告白事件 ==========
// TODO：实现 trigger() 和 getDialogue()

// ========== 子类：文化祭事件 ==========
// TODO：实现 trigger() 和 getDialogue()

// ========== 子类：离别事件 ==========
// TODO：实现 trigger() 和 getDialogue()

// ========== 主方法（已写好，不要改） ==========
public class AbstractRoute {
    public static void main(String[] args) {
        RouteEvent confession = new ConfessionEvent("告白", 85);
        RouteEvent festival = new FestivalEvent("文化祭", 70);
        RouteEvent farewell = new FarewellEvent("离别", 90);

        RouteEvent[] events = {confession, festival, farewell};
        for (RouteEvent event : events) {
            event.displayHeader();
            event.trigger();
            event.showResult();
        }
    }
}
