/**
 * final 练习 - 银行账户
 *
 * 知识点：final、static final、final 方法、final 类
 *
 * 任务：补全三个类，使 main 方法输出与期望一致。
 *
 * 期望输出：
 *   === 银行信息 ===
 *   银行名称: 招商银行
 *   总账户数: 2
 *
 *   === 账户信息 ===
 *   账户A - 卡号: 6222001, 余额: 10000.0, 年利率: 1.5%
 *   账户B - 卡号: 6222002, 余额: 5000.0, 年利率: 2.0%
 *
 *   === 交易 ===
 *   账户A 利息: 150.0
 *   账户B 利息: 100.0
 *
 *   === 锁定账户（不可被继承） ===
 *   冻结账户: 6222003, 余额: 0.0
 */

class Bank{
    public static String Bankname = "招商银行";
    public static int accountAmount = 2;
    Bank(String Bankname,int accountAmount){
        this.Bankname=Bankname;
        this.accountAmount=accountAmount;
    }
    public static void printBankInfo(){
        System.out.println("银行名称： "+ Bankname + "\n总账户数:"+ accountAmount);
    }
}

class Account{
    public final String cardNum;
    private double balance;
    private final double annualInterestRate;

    public Account(String cardNum, double balance,double annualInterestRate) {
        this.cardNum=cardNum;
        this.balance=balance;
        this.annualInterestRate=annualInterestRate;
    }

    public double calculateInterest(){
        return balance * annualInterestRate / 100;
    }

    public String toString(){
        return "卡号: "+ cardNum+ " 余额:"+ balance + "年利率："+ annualInterestRate +"%";
    }
    
}

final class LockedAccount extends Account{
 LockedAccount(String cardNum){
    super(cardNum,0.0,0.0);
    } 
}


// ========== 主方法（已写好，不要改） ==========
public class Practice_07 {
    public static void main(String[] args) {
        System.out.println("=== 银行信息 ===");
        Bank.printBankInfo();

        System.out.println("\n=== 账户信息 ===");
        Account a = new Account("6222001", 10000.0, 1.5);
        Account b = new Account("6222002", 5000.0, 2.0);
        System.out.println("账户A - " + a);
        System.out.println("账户B - " + b);

        System.out.println("\n=== 交易 ===");
        System.out.println("账户A 利息: " + a.calculateInterest());
        System.out.println("账户B 利息: " + b.calculateInterest());

        System.out.println("\n=== 锁定账户（不可被继承） ===");
        LockedAccount frozen = new LockedAccount("6222003");
        System.out.println("冻结账户: " + frozen);
    }
}
