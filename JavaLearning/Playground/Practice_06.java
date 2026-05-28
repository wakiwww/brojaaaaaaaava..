

/**
 * final 练习 - 配置系统
 *
 * 知识点：final、static final、final 方法、final 类
 *
 * 任务：补全三个类，使 main 方法输出与期望一致。
 *
 * 期望输出：
 *   数据库配置: MySQL:3306
 *   数据库配置（已锁定）: MySQL:3306
 *   连接成功
 *   用户数: 100
 */

// ========== 父类 BaseConfig ==========
class BaseConfig {
    // TODO: 定义 static final MAX_CONN = 100
    // TODO: 定义 final 方法 getConfig()，返回配置信息
    public static final int MAX_CONN = 100;
    private final int getConfig(){
            return MAX_CONN;
    }
}

// ========== 子类 DBConfig ==========
class DBConfig extends BaseConfig {
    // TODO: 定义 private final 变量 dbType 和 port
    private final String dbType;
    private final int port;

    // TODO: 构造方法初始化 dbType 和 port
    public DBConfig(String dbType,int port) {
        this.dbType = dbType;
        this.port = port;
    }

    

    // TODO: 重写 getConfig()，返回 "MySQL:3306" 格式
    protected int getConfig(){
       return port;
    }
}



// ========== final 子类（不能被继承） ==========
// TODO: 用 final 修饰 LockedDBConfig 类，继承 DBConfig
    final class LockedDBConfig extends DBConfig{

    public LockedDBConfig(String dbType,int port) {
        super(dbType, port);
    }
        
    }
// ========== 主方法（已写好，不要改） ==========
public class Practice_06 {
    public static void main(String[] args) {
        DBConfig config = new DBConfig("MySQL", 3306);
        System.out.println("数据库配置: " + config.getConfig());

        LockedDBConfig locked = new LockedDBConfig("MySQL", 3306);
        System.out.println("数据库配置（已锁定）: " + locked.getConfig());

        System.out.println("连接成功");
        System.out.println("用户数: " + BaseConfig.MAX_CONN);
    }
}
