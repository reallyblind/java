package com.blind.java2;

/**
 * 线程通信的应用
 * 生产者Productor将产品交给店员Clerk，而消费者Customer从店员处取走产品，
 * 电源一次只能持有固定数量的产品（比如20），如果生产者试图生产更多的产品，店员会叫生产者
 * 听一下，如果店中有空位置放产品了再通知生产者继续生产；如果店中没有产品，店员会告诉消费者
 * 等一下，如果店中有产品了再通知消费者取走产品
 *
 * 分析：
 * 1. 是否是多线程问题？是，生产者线程，消费者线程
 * 2. 是否有共享数据？是，店员（或产品）
 * 3. 如何解决线程安全问题？同步机制，三种方法
 * 4. 是否涉及线程通信？是
 *
 *
 * @author blind
 * @create 2022-08-21-21:25
 */
class Clerk{
    private int productCount = 0;
    //生产产品
    public synchronized void produceProduct()  {
        if(productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+"开始生产第"+productCount+" 个产品");

            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeProduct() {
        if(productCount > 0){
            System.out.println(Thread.currentThread().getName() +"开始消费第"+productCount+"个产品");
            productCount--;

            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Productor extends Thread{//生产者
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+":"+"开始生产....");

        while(true){
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.produceProduct();
        }
    }
}
class Consumer extends Thread{//消费者
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+":"+"开始消费....");

        while(true){
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.consumeProduct();
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Productor p1 = new Productor(clerk);
        p1.setName("生产者1");

        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者1");

        p1.start();
        c1.start();
    }
}
