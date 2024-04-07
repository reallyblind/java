package com.blind.java;

/**
 * 静态代理举例
 *
 * 特点：代理类和被代理类在编译期间，就确定下来了
 * @author blind
 * @create 2022-10-04-13:32
 */
interface ClothFactory{

    void productCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory;//用被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory factory){
        this.factory=factory;
    }
    @Override
    public void productCloth() {
        System.out.println("代理工厂做一些准备工作");

        factory.productCloth();

        System.out.println("代理工厂做一些后续收尾工作");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory{


    @Override
    public void productCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类的对象
        ClothFactory nike = new NikeClothFactory();
        //创建代理类的对象
        ClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.productCloth();
    }
}
