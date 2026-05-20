
/**
 * 练习题 - 设计一个「银行账户系统」
 *
 * 要求：
 *   1. 创建一个 BankAccount 类，包含以下属性：
 *      - 账户持有人（owner）
 *      - 账号（accountNumber）
 *      - 余额（balance）
 *      - 账户是否冻结（isFrozen）
 *
 *   2. 提供两个构造方法：
 *      - 有参构造：传入持有人和账号，余额默认0，未冻结
 *      - 无参构造：持有人默认"未知"，账号默认"000000"，余额默认0，未冻结
 *
 *   3. 提供 getter（所有属性）和 setter（仅 owner 和 isFrozen）
 *
 *   4. 提供以下方法：
 *      - deposit(double amount)：存款。
 *        如果金额 <= 0，打印"存款金额必须为正数"
 *        如果账户已冻结，打印"账户已冻结，无法存款"
 *        否则余额增加，打印"存款成功，当前余额：xxx"
 *
 *      - withdraw(double amount)：取款。
 *        如果金额 <= 0，打印"取款金额必须为正数"
 *        如果账户已冻结，打印"账户已冻结，无法取款"
 *        如果余额不足，打印"余额不足，当前余额：xxx"
 *        否则余额减少，打印"取款成功，当前余额：xxx"
 *
 *      - transfer(BankAccount other, double amount)：转账。
 *        从当前账户转到 other 账户，需要同时检查两个账户是否冻结
 *        转账成功后打印"转账成功，当前余额：xxx"
 *
 *      - displayInfo()：打印账户全部信息
 *
 *   5. 在 main 方法中测试：
 *      - 创建3个账户（至少用一次无参构造）
 *      - 测试存款、取款（正常、余额不足、负数金额）
 *      - 测试转账（正常、冻结账户）
 *      - 测试冻结/解冻后操作是否生效
 *
 * 提示：
 *   - deposit 和 withdraw 要处理多种异常情况，注意 if-else 的顺序
 *   - transfer 方法需要在当前账户取款，在对方账户存款
 *   - balance 不提供 setter，只能通过 deposit/withdraw 来修改（保护余额）
 */
class BankAccount {

    // 在这里写你的代码
    private String owner;
    private String accountNumber;
    private double balance;
    private boolean isFrozen;

    public BankAccount() {
        this.owner = "unknown";
        this.accountNumber = "000000";
        this.balance = 0.0;
        this.isFrozen = false;
    }

    public BankAccount(String owner, String accountNumber, double balance, boolean isFrozen) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.isFrozen = isFrozen;

    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean getIsFrozen() {
        return isFrozen;
    }

    public void setIsfrozen(boolean isFrozen) {
        this.isFrozen = isFrozen;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("存款金额必须为正数");
            return;
        }
        if (isFrozen) {
            System.out.println("账户已冻结，无法存款");
            return;
        }
        balance = balance + amount;
        System.out.println("存款成功，当前余额：" + balance);

    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("取款金额必须为正数");
            return;
        }
        if (isFrozen) {
            System.out.println("账户已冻结，无法正常取款");
            return;
        }
        if (balance <= amount) {
            System.out.println("余额不足，当前：" + balance);

        }
        else{
            balance=balance-amount;
            System.out.println("取款成功，当前："+balance);
        }
    }
    public void displayInfo(){
        getAccountNumber();
        getBalance();
        getClass();
        getIsFrozen();
    }

}

public class Practice_02 {

    public static void main(String[] args) {
        // 在这里写你的测试代码
        BankAccount acc1 = new BankAccount("xixian","aweqr222",8000000,false);
        BankAccount acc2 = new BankAccount();

        acc1.deposit(1000000);
        acc1.displayInfo();
        acc1.withdraw(3);




    }
}
