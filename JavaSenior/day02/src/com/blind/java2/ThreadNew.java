package com.blind.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口。-----JDK5.0新增
 *
 *如何理解实现Callable接口的方式创建多线程比实现Runnable接口更强大
 * 1. call()可以有返回值
 * 2. call()可以抛出异常，被外面的操作捕获，获取异常的信息
 * 3. Callable是支持泛型的
 *
 *
 * @author blind
 * @create 2022-08-21-22:14
 */
//1.创建一个实现callable的实现类
class NumThread implements Callable{
    //2.实现call方法，将此线程需要执行的操作声明在此方法中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for(int i = 0;i <= 100 ;i++){
            if(i%2 == 0 ){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}


public class ThreadNew {
    public static void main(String[] args) {
        //3.创建callcable接口实现类的对象
        NumThread numThread = new NumThread();
        //4.将此callcable接口实现类的对象作为参数传递到FutureTest构造器中，创建FutureTest的对象
        FutureTask futureTask = new FutureTask(numThread);
        //5.将FutureTest的对象作为参数传递到Thread类中，创建Thread类对象，并调用start
        new Thread(futureTask).start();

        try {
            //6.获取callcble中的call方法的返回值
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值
            Object sum = futureTask.get();
            System.out.println("总和为"+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
