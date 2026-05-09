/**
 * 练习题 - 设计一个「图书管理系统」
 *
 * 要求：
 *   1. 创建一个 Book 类，包含以下属性：
 *      - 书名（title）
 *      - 作者（author）
 *      - 价格（price）
 *      - 是否已借出（isBorrowed）
 *
 *   2. 提供两个构造方法：
 *      - 无参构造：书名默认"未知"，作者默认"未知"，价格默认0，未借出
 *      - 有参构造：传入书名、作者、价格，未借出
 *
 *   3. 提供 getter/setter（price 的 setter 要加校验：不能为负数）
 *
 *   4. 提供以下方法：
 *      - borrow()：借书。如果已借出，打印"已被借出"；否则标记为已借出，打印"借书成功"
 *      - returnBook()：还书。如果未借出，打印"无需归还"；否则标记为未借出，打印"还书成功"
 *      - displayInfo()：打印书的全部信息
 *
 *   5. 在 main 方法中测试：
 *      - 创建2本书（分别用无参和有参构造）
 *      - 借书、还书、重复借书，观察输出
 *      - 尝试设置负数价格，看 setter 是否生效
 *
 * 提示：参考各章节的注释，特别是 Chapter4 的 this、setter、构造方法部分
 */
class Book{
    private String title;
    private String author;
    private double price;
    private boolean isBorrowed;

    public Book(){
    this.title = "unknown";
    this.author = "unknown";
    this.price = 0.0;
    this.isBorrowed = false;
}
public Book(String title, String author, double price){
    this.title = title;
    this.author = author;
    this.price = price;
    this.isBorrowed = false;
}
public void borrow (){
    if(isBorrowed!=true){
        isBorrowed = true;
    }else{
        System.out.println("已被借出");
    }
}
public void returnBook(){
    if(isBorrowed!=false){
        isBorrowed=false;
    }else{
        System.out.println("无需归还");
    }
}
public void displayInfo(){
    System.out.println("书名："+title);
    System.out.println("作者："+author);
    System.out.println("价格："+price);
    System.out.println("是否已借出："+isBorrowed);
}
public String getTitle(){
    System.out.println("书名："+title);
    return title;
}
public String setPrice(double price){
    if(price<0){
        System.out.println("价格不能为负数");
    }else{
        this.price = price;
        System.out.println("价格设置成功");
    }
}
}
public class Practice {
    public static void main(String[] args) {
        // 在这里写你的测试代码
        Book book1 = new Book("香蕉种植方法", "博罗", 128.0);
        Book book2 = new Book();
        book1.displayInfo();
        book1.getTitle();
        book1.setPrice(200);
        book1.borrow();
        book1.returnBook();
        book1.setPrice(-100);
    }
}
