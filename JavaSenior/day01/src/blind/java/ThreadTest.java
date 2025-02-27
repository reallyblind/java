package blind.java;

/**
 *
 * 多线程的创建，方式一：继承于thread类
 * 1. 创建一个继承于Thread类的子类
 * 2. 重写Thread类的run（）方法-->此线程执行的操作
 * 3. 创建Thread子类的对象
 * 4.通过此对象调用start（）方法
 *
 * @author blind
 * @create 2022-08-17-17:13
 */

//1. 创建一个继承于Thread类的子类
class MyThread extends Thread{
    //2. 重写Thread类的run（）方法
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }

    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //3. 创建Thread子类的对象
        MyThread t1 = new MyThread();

        //4.通过此对象调用start（）方法:①启动当前线程 ②调用当前线程的run（）
        t1.start();

        //问题一：我们不能通过直接调用run方法启动线程
        t1.run();
        //问题二：再启动一个线程，遍历100以内的偶数，不可以还让已经start（）的线程去执行。会报IllegalThreadStateException
        t1.start();



        System.out.println("hello");

    }

}
