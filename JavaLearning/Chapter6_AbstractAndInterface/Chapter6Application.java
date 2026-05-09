/**
 * 第6章 综合应用 - 支付系统
 * 知识点：综合运用抽象类、接口、Lambda表达式等
 */

// 接口 - 支付方式
interface PaymentMethod {
    void pay(double amount);
    boolean validateAccount();
    String getPaymentType();
}

// 接口 - 交易记录
interface TransactionLogger {
    void logTransaction(String transactionId, double amount, String status);
}

// 抽象类 - 支付处理基类
abstract class PaymentProcessor {
    protected String processorId;
    protected TransactionLogger logger;

    public PaymentProcessor(String processorId, TransactionLogger logger) {
        this.processorId = processorId;
        this.logger = logger;
    }

    // 抽象方法 - 子类必须实现
    abstract public void processPayment(double amount);
    abstract public double getFee(double amount);

    // 具体方法
    protected void recordTransaction(String transactionId, double amount, String status) {
        if (logger != null) {
            logger.logTransaction(transactionId, amount, status);
        }
    }

    public String getProcessorId() {
        return processorId;
    }
}

// 支付宝实现
class AlipayProcessor extends PaymentProcessor implements PaymentMethod {
    private String accountId;
    private double balance;

    public AlipayProcessor(String processorId, String accountId, double balance,
                          TransactionLogger logger) {
        super(processorId, logger);
        this.accountId = accountId;
        this.balance = balance;
    }

    @Override
    public void processPayment(double amount) {
        if (validateAccount() && balance >= amount) {
            balance -= amount;
            System.out.println("支付宝支付成功: ¥" + amount);
            recordTransaction("AP" + System.currentTimeMillis(), amount, "SUCCESS");
        } else {
            System.out.println("支付宝支付失败: 余额不足");
            recordTransaction("AP" + System.currentTimeMillis(), amount, "FAILED");
        }
    }

    @Override
    public void pay(double amount) {
        processPayment(amount + getFee(amount));
    }

    @Override
    public boolean validateAccount() {
        return accountId != null && !accountId.isEmpty();
    }

    @Override
    public String getPaymentType() {
        return "支付宝";
    }

    @Override
    public double getFee(double amount) {
        return amount * 0.001;  // 0.1% 手续费
    }
}

// 微信支付实现
class WechatPayProcessor extends PaymentProcessor implements PaymentMethod {
    private String openId;
    private double balance;

    public WechatPayProcessor(String processorId, String openId, double balance,
                             TransactionLogger logger) {
        super(processorId, logger);
        this.openId = openId;
        this.balance = balance;
    }

    @Override
    public void processPayment(double amount) {
        if (validateAccount() && balance >= amount) {
            balance -= amount;
            System.out.println("微信支付成功: ¥" + amount);
            recordTransaction("WX" + System.currentTimeMillis(), amount, "SUCCESS");
        } else {
            System.out.println("微信支付失败: 余额不足");
            recordTransaction("WX" + System.currentTimeMillis(), amount, "FAILED");
        }
    }

    @Override
    public void pay(double amount) {
        processPayment(amount + getFee(amount));
    }

    @Override
    public boolean validateAccount() {
        return openId != null && !openId.isEmpty();
    }

    @Override
    public String getPaymentType() {
        return "微信";
    }

    @Override
    public double getFee(double amount) {
        return amount * 0.0015;  // 0.15% 手续费
    }
}

// 银行卡实现
class BankCardProcessor extends PaymentProcessor implements PaymentMethod {
    private String cardNumber;
    private double balance;

    public BankCardProcessor(String processorId, String cardNumber, double balance,
                            TransactionLogger logger) {
        super(processorId, logger);
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    @Override
    public void processPayment(double amount) {
        if (validateAccount() && balance >= amount) {
            balance -= amount;
            System.out.println("银行卡支付成功: ¥" + amount);
            recordTransaction("BC" + System.currentTimeMillis(), amount, "SUCCESS");
        } else {
            System.out.println("银行卡支付失败: 余额不足");
            recordTransaction("BC" + System.currentTimeMillis(), amount, "FAILED");
        }
    }

    @Override
    public void pay(double amount) {
        processPayment(amount + getFee(amount));
    }

    @Override
    public boolean validateAccount() {
        return cardNumber != null && cardNumber.length() == 16;
    }

    @Override
    public String getPaymentType() {
        return "银行卡";
    }

    @Override
    public double getFee(double amount) {
        return 0;  // 没有手续费
    }
}

// 支付网关 - 管理所有支付方式
class PaymentGateway {
    private java.util.List<PaymentMethod> paymentMethods = new java.util.ArrayList<>();
    private TransactionLogger logger;

    public PaymentGateway(TransactionLogger logger) {
        this.logger = logger;
    }

    public void registerPaymentMethod(PaymentMethod method) {
        paymentMethods.add(method);
    }

    // 列出所有可用的支付方式
    public void listPaymentMethods() {
        System.out.println("可用支付方式:");
        paymentMethods.forEach(method -> System.out.println("- " + method.getPaymentType()));
    }

    // 处理支付 - 使用Lambda筛选
    public void processPaymentByType(String paymentType, double amount) {
        paymentMethods.stream()
                      .filter(method -> method.getPaymentType().equals(paymentType))
                      .forEach(method -> method.pay(amount));
    }
}

// 演示支付系统
class Chapter6Application {
    public static void main(String[] args) {
        System.out.println("========== 支付系统演示 ==========\n");

        // 创建交易日志记录器 - 使用Lambda实现
        TransactionLogger logger = (id, amount, status) ->
            System.out.println("  [记录] 交易ID: " + id + ", 金额: ¥" + amount +
                             ", 状态: " + status);

        // 创建支付网关
        PaymentGateway gateway = new PaymentGateway(logger);

        // 注册支付方式
        gateway.registerPaymentMethod(new AlipayProcessor("P001", "zhangsan@alipay", 500, logger));
        gateway.registerPaymentMethod(new WechatPayProcessor("P002", "wxuser123", 300, logger));
        gateway.registerPaymentMethod(new BankCardProcessor("P003", "1234567890123456", 1000, logger));

        // 列出支付方式
        gateway.listPaymentMethods();

        // 进行支付
        System.out.println("\n--- 执行支付 ---");
        gateway.processPaymentByType("支付宝", 100);
        gateway.processPaymentByType("微信", 50);
        gateway.processPaymentByType("银行卡", 200);
    }
}
