import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class TimeRunnable implements Runnable {
    private volatile boolean isRunning = true;

    public void stopThread() {
        isRunning = false;
    }
        @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (isRunning) {
            String currentTime = sdf.format(new Date());
            System.out.println(currentTime);
            System.out.println("当前时间" + currentTime);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("线程被中断了");
                break;
            }
        }
        System.out.println("线程结束了");
    }

    public static void main(String[] args) {
        TimeRunnable timeRunnable = new TimeRunnable();
        Thread thread = new Thread(timeRunnable);
        thread.start();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入stop来停止线程");
        while (true) {
            String input = scanner.nextLine();
            if ("stop".equalsIgnoreCase(input)) {
                timeRunnable.stopThread();
                break;
            }
        }
        scanner.close();
    }
}