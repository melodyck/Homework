package day09;
/**
 * 使用线程方式二创建两个线程:分别输出1000次，你好和再见
 * @author Bonnie
 *
 */
public class Test02 {
    private static class Task1 implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println("你好");
            }
        }
    }
    private static class Task2 implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println("再见");
            }
        }
    }
    public static void main(String[] args){
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
    }
}
