package com.blind.java;

/**
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于class java.lang.Enum
 *
 * @author blind
 * @create 2022-08-25-12:12
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;

        //toString():显示枚举变量名
        System.out.println(summer.toString());

        System.out.println(Season1.class.getSuperclass());
        System.out.println("************");


        //values():返回枚举类对象数组
        Season1[] values = Season1.values();
        for(int i = 0;i<values.length;i++)
            System.out.println(values[i]);
        System.out.println("************");
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);

        }

        //valueOf(String objName):返回枚举类中对象名是objName的对象
        //如果没有objName的枚举类对象，则抛出IllegalArgumentException异常
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
        winter.show();


    }

}

interface Info{
    void show();
}

enum Season1 implements Info{
    //1.提供当前枚举类的对象，多个对象之间用,末尾用";"
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天子啊哪里");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天分手");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    //2.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器
    private Season1(String seasonName,String seasonDesc){
        this.seasonDesc =seasonDesc;
        this.seasonName = seasonName;
    }


    //4.其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }


//    //4.其他诉求2:提供toString方法
//
//
//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
