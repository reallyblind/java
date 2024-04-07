package com.blind.java;

/**
 * @author blind
 * @create 2022-10-01-22:23
 */
public class Person {
    private String name;
    public int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private Person(String name) {
        this.name = name;
    }



    public Person() {
    }
    public void show(){
        System.out.println("我是一个人");
    }
    private String showNation(String nation){
        System.out.println("我的国籍是"+nation);
        return nation;
    }


}
