package com.blind.java;


/**
 *
 *
 * @author blind
 * @create 2022-08-17-22:41
 */

class Window extends Thread {
    private static int ticket = 100;
    private static Object obj = new Object();
    {


    }

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + ":买票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}


public class WindowTest2 {
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}
