package com.blind.java;


/**
 *使用同步方法处理继承Thread类的方式中的线程安全问题
 *
 * @author blind
 * @create 2022-08-17-22:41
 */

class Window4 extends Thread {
    private static int ticket = 100;
    private static synchronized void show(){
        if (ticket > 0) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":买票，票号为：" + ticket);
            ticket--;
        }
    }

    @Override
    public void run() {
        while (true) {
                show();
            }

    }
}


public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}
