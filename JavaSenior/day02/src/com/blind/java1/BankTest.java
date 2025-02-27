package com.blind.java1;

/**
 *
 * 使用同步机制将单例中的懒汉式改写为线程安全的
 * @author blind
 * @create 2022-08-20-10:19
 */
class Bank{
    private Bank(){}
    private static Bank instance = null;
    public static  Bank getInstance(){

        //方式一：效率较差
//        synchronized(Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
        //方式二：效率更高
        if (instance == null) {
            synchronized(Bank.class){
                if(instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;

    }



}

public class BankTest {
}
