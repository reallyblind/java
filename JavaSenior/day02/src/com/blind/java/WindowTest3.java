package com.blind.java;

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 *
 * @author blind
 * @create 2022-08-18-20:17
 */
class Window3 implements Runnable{

    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            show();
        }
    }
    public synchronized  void show() {//同步监视器：this
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "票号：" + ticket);
            ticket--;
        }
    }

}

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }

}
