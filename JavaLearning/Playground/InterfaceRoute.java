/**
 * 接口练习 - Galgame 角色能力系统
 *
 * 知识点：interface、implements、多接口实现、接口多态
 *
 * 背景：每个女主角有自己的"女子力"能力，能力用接口定义。
 *       不同角色可以拥有不同能力组合，系统根据能力类型调用对应方法。
 *
 * 任务：补全接口和实现类，使 main 方法输出与期望一致。
 *
 * 期望输出：
 *   === 能力展示 ===
 *   雪乃在厨房里认真料理...
 *   雪乃做出了精致的和食！
 *
 *   理世在音乐室里练习...
 *   理世的歌声打动了所有人！
 *
 *   小町坐在缝纫机前...
 *   小町亲手缝制了可爱的裙子！
 *
 *   === 能力测试 ===
 *   料理测试：雪乃通过了！
 *   歌唱测试：理世通过了！
 *   裁缝测试：小町通过了！
 */

// ========== 接口1：料理能力 ==========
// TODO
interface Cookable{
    void cook();
    void makeDish();
}
// ========== 接口2：歌唱能力 ==========
// TODO
interface Singable{
    void sing();
    void perform();
}
// ========== 接口3：裁缝能力 ==========
// TODO
interface Sewable{
    void sew();
    void makeDress();
}
// ========== 角色1：青梅竹马（只有料理能力） ==========
// TODO
    class ChildhoodFriend implements Cookable{
    String name;

    public ChildhoodFriend(String name) {
    this.name=name;
    }
    public void cook(){
        System.out.println("雪乃在厨房里认真料理...");
    }
    public void makeDish(){
        System.out.println("雪乃做出了精致的和食！\n");
    }

    
}
// ========== 角色2：学生会长（只有歌唱能力） ==========
// TODO
    class StudentCouncil implements Singable{
    String name;

    public StudentCouncil(String name) {
    this.name=name;
    }
    public void sing(){
        System.out.println("理世在音乐室里练习...");
    }
    public void perform(){
        System.out.println("理世的歌声打动了所有人\n！");
    }

}
// ========== 角色3：转校生（裁缝+歌唱能力） ==========
// TODO
    class TransferStudent implements Sewable,Singable{
        String name;

    public TransferStudent(String name) {
    this.name=name;
    }
    public void sing(){
        System.out.println("小丁在音乐室...");
    }
    public void perform(){
        System.out.println("小丁唱出了动人的歌曲\n！");
    }
    public void sew(){
        System.out.println("小町坐在缝纫机前...");
    }
    public void makeDress() {
        System.out.println("小町亲手缝制了可爱的裙子！");
    }
}
// ========== 主方法（已写好，不要改） ==========
public class InterfaceRoute {
    public static void main(String[] args) {
        ChildhoodFriend yuki = new ChildhoodFriend("雪乃");
        StudentCouncil riko = new StudentCouncil("理世");
        TransferStudent makoto = new TransferStudent("小町");

        // 展示各自能力
        System.out.println("=== 能力展示 ===");
        yuki.cook();
        yuki.makeDish();

        riko.sing();
        riko.perform();

        makoto.sew();
        makoto.makeDress();

        // 接口多态：用接口数组统一测试
        System.out.println("\n=== 能力测试 ===");
        Cookable[] cooks = {yuki};
        for (Cookable c : cooks) {
            c.cook();
            System.out.println("料理测试：通过！");
        }

        Singable[] singers = {riko, makoto};
        for (Singable s : singers) {
            s.sing();
            System.out.println("歌唱测试：通过！");
        }

        Sewable[] sewers = {makoto};
        for (Sewable sw : sewers) {
            sw.sew();
            System.out.println("裁缝测试：通过！");
        }
    }
}
