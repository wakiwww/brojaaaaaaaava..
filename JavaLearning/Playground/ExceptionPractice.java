/**
 * 异常处理练习 - Galgame 存档系统
 *
 * 知识点：try-catch、throw、throws、自定义异常
 *
 * 任务：补全 SaveManager 类，使 main 方法输出与期望一致。
 *
 * 期望输出：
 *   === 存档系统启动 ===
 *
 *   存档成功: save_01.dat
 *
 *   存档失败: 文件名不能为空
 *
 *   存档失败: 文件名不能包含特殊字符
 *
 *   存档成功: save_02.dat
 *
 *   读档成功: save_02.dat
 *
 *   读档失败: 存档文件不存在
 */

// ========== 自定义异常 ==========
class InvalidSaveException extends Exception{
    public InvalidSaveException(String message){
        super(message);
    }
}
class SaveManager {
    public void save(String filename) throws InvalidSaveException{
        if(filename == null || filename.isEmpty()){
            throw new InvalidSaveException("文件名不能为空");
        }
        if(filename.matches(".*[!@#$%^&()].*")){
            throw new InvalidSaveException("文件名不能包含特殊字符");
        }else{
            System.out.println("存档成功: "+filename);
        }
    }
    public void load(String filename) throws InvalidSaveException{
        if(filename ==null || filename.isEmpty()){
            throw new InvalidSaveException("存档文件不存在");
        }else{
            System.out.println("读档成功: "+filename);
        }
    }

}


// ========== 主方法 ==========
public class ExceptionPractice {
    public static void main(String[] args) {
        SaveManager manager = new SaveManager();

        System.out.println("=== 存档系统启动 ===\n");

        try {
            manager.save("save_01.dat");
        } catch (InvalidSaveException e) {
            System.out.println("存档失败: " + e.getMessage());
        }

        try {
            manager.save("");
        } catch (InvalidSaveException e) {
            System.out.println("存档失败: " + e.getMessage());
        }

        try {
            manager.save("save@02.dat");
        } catch (InvalidSaveException e) {
            System.out.println("存档失败: " + e.getMessage());
        }

        try {
            manager.save("save_02.dat");
        } catch (InvalidSaveException e) {
            System.out.println("存档失败: " + e.getMessage());
        }

        try {
            manager.load("save_02.dat");
        } catch (InvalidSaveException e) {
            System.out.println("读档失败: " + e.getMessage());
        }

        try {
            manager.load(null);
        } catch (InvalidSaveException e) {
            System.out.println("读档失败: " + e.getMessage());
        }
    }
}
