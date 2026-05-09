/**
 * 第7章 - 7.1 数组的基本操作
 *
 * 【核心概念】数组 = 存储相同类型元素的固定大小容器
 *   声明：int[] arr = new int[5];  → 创建长度为5的数组，元素默认为0
 *   初始化：int[] arr = {1, 2, 3}; → 直接赋值
 *
 * 【索引】从 0 开始
 *   arr[0] 是第一个元素，arr[arr.length-1] 是最后一个
 *   越界访问（如 arr[5] 在长度为5的数组中）会报 ArrayIndexOutOfBoundsException
 *
 * 【常用操作】
 *   - 遍历：for 循环 或 for-each（for (int x : arr)）
 *   - 排序：Arrays.sort(arr)
 *   - 搜索：Arrays.binarySearch(arr, target)（需要先排序）
 *   - 复制：Arrays.copyOf(arr, newLength)
 *   - 打印：Arrays.toString(arr)
 */

public class ArrayBasics {

    // ========== 一维数组 ==========
    static class OneDimensionalArray {
        public static void main(String[] args) {
            System.out.println("=== 一维数组操作 ===\n");

            // 1. 创建数组：new int[5] 分配5个位置，每个位置默认值为0
            int[] scores = new int[5];
            scores[0] = 85;   // 给第1个位置赋值
            scores[1] = 90;
            scores[2] = 78;
            scores[3] = 92;
            scores[4] = 88;
            // scores[5] = 100;  // ❌ 越界！索引最大是4

            // 2. for-each 遍历：依次取出每个元素，赋给 score
            // 适合"只需要读取值，不需要索引"的场景
            System.out.println("成绩列表:");
            for (int score : scores) {
                System.out.println(score + " ");
            }
            System.out.println();

            // 3. 排序：Arrays.sort() 直接修改原数组（升序）
            java.util.Arrays.sort(scores);
            System.out.println("排序后:");
            for (int score : scores) {
                System.out.print(score + " ");
            }
            System.out.println();

            // 4. 二分搜索：在已排序的数组中查找元素，返回索引
            // 注意：必须先排序才能用 binarySearch！
            int target = 90;
            int index = java.util.Arrays.binarySearch(scores, target);
            System.out.println("搜索" + target + "的位置: " + index);

            // 5. 复制数组：创建一个新数组，内容和原数组一样
            int[] copyScores = java.util.Arrays.copyOf(scores, scores.length);
            System.out.println("复制后的数组: " + java.util.Arrays.toString(copyScores));

            // 6. 字符串数组
            String[] names = {"Alice", "Bob", "Charlie"};
            System.out.println("姓名列表: " + java.util.Arrays.toString(names));
        }
    }

    // ========== 二维数组 ==========
    // 二维数组 = 数组的数组，像一个表格（行×列）
    static class TwoDimensionalArray {
        public static void main(String[] args) {
            System.out.println("\n=== 二维数组操作 ===\n");

            // 创建 2行3列 的二维数组
            // matrix[0] = {1, 2, 3}  → 第一行
            // matrix[1] = {4, 5, 6}  → 第二行
            int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
            };

            // 双重循环遍历：外层控制行，内层控制列
            System.out.println("矩阵内容:");
            for (int i = 0; i < matrix.length; i++) {           // matrix.length = 行数
                for (int j = 0; j < matrix[i].length; j++) {   // matrix[i].length = 第i行的列数
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            // for-each 遍历二维数组
            int sum = 0;
            for (int[] row : matrix) {        // 每次取出一行（一个一维数组）
                for (int value : row) {       // 再遍历这一行的每个元素
                    sum += value;
                }
            }
            System.out.println("矩阵总和: " + sum);

            // 矩阵转置：行列互换
            // 原矩阵：    转置后：
            // 1 2 3      1 4
            // 4 5 6      2 5
            //            3 6
            System.out.println("转置后的矩阵:");
            for (int j = 0; j < matrix[0].length; j++) {   // 先遍历列
                for (int i = 0; i < matrix.length; i++) {   // 再遍历行
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    // ========== 数组工具方法 ==========
    static class ArrayUtilities {
        // 查找最大值：遍历数组，记住最大的那个
        public static int findMax(int[] arr) {
            int max = arr[0];  // 假设第一个是最大的
            for (int value : arr) {
                if (value > max) max = value;  // 发现更大的就更新
            }
            return max;
        }

        // 查找最小值：同理
        public static int findMin(int[] arr) {
            int min = arr[0];
            for (int value : arr) {
                if (value < min) min = value;
            }
            return min;
        }

        // 计算平均值：总和 ÷ 个数
        public static double calculateAverage(int[] arr) {
            int sum = 0;
            for (int value : arr) {
                sum += value;
            }
            return (double) sum / arr.length;  // 强转为 double，否则整数除法会丢小数
        }

        // 反转数组：首尾交换
        // 只需要交换一半的次数（length/2）
        public static void reverse(int[] arr) {
            for (int i = 0; i < arr.length / 2; i++) {
                int temp = arr[i];                    // 先存起来
                arr[i] = arr[arr.length - 1 - i];     // 把末尾的值放到开头
                arr[arr.length - 1 - i] = temp;       // 把存起来的值放到末尾
            }
        }

        public static void main(String[] args) {
            System.out.println("\n=== 数组工具方法 ===\n");

            int[] data = {23, 45, 12, 56, 34, 89, 10};

            System.out.println("原数组: " + java.util.Arrays.toString(data));
            System.out.println("最大值: " + findMax(data));
            System.out.println("最小值: " + findMin(data));
            System.out.println("平均值: " + calculateAverage(data));

            reverse(data);
            System.out.println("反转后: " + java.util.Arrays.toString(data));
        }
    }

    public static void main(String[] args) {
        OneDimensionalArray.main(args);
        TwoDimensionalArray.main(args);
        ArrayUtilities.main(args);
    }
}
