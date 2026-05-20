/**
 * 【练习题】static 考一考
 *
 * 补全下面的 BankAccount 类，让它满足以下要求：
 *
 *   1. 每个账户有自己的 owner（户主）和 balance（余额）→ 实例变量
 *   2. 所有账户共享一个 bankName（银行名称）→ 静态变量，默认值 "中国银行"
 *   3. 提供静态方法 setBankName()，可以修改银行名称
 *   4. 提供实例方法 showInfo()，打印：
 *      "户主: xxx, 余额: xxx, 银行: xxx"
 *   5. 在 main 方法中：
 *      - 先用类名调用 setBankName("工商银行")
 *      - 创建 2 个账户（自己编名字和余额）
 *      - 打印每个账户的信息
 *
 * 提示：
 *   - static 变量怎么声明？
 *   - 静态方法和实例方法的区别？
 *   - 静态方法里能用 this 吗？
 */

public class Practice_03 {

    // ===== 在这里补全代码 =====
public Practice_03(String owner, Double balance) {
    this.owner = owner;
    this.balance = balance;
}
    private String owner;
    private Double balance;
    private static String bankName = "zhaoshang";//因为银行名字是大家都一样的

    public void showInfo(){
        System.out.println("户主: "+ owner+" 余额："+balance);
    }
/* 为什么改银行名用static？因为改银行名是要共享给所有用户的 */
    public static void setBankName(String bankName) {
        Practice_03.bankName = bankName;

        }
    public static void main(String[] args) {
        Practice_03.setBankName("招商");
        Practice_03 a1 = new Practice_03("zhangsan",1000.1);//实例方法，必须先创建对象
        a1.showInfo();
    }
}



    // ===== 主方法 =====

