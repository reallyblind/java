package com.blind.java1;

/**
 * @author blind
 * @create 2022-10-02-16:08
 */
@MyAnnotion(value="hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{

    private String name;
    int age;
    public int id;

    public Person() {
    }
    @MyAnnotion(value="abc")
    private Person(String name) {
        this.name = name;
    }

    Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String display(String interests,int age){
        return interests+age;

    }
    @MyAnnotion
    private String show(String nation){
        System.out.println("我的国际是"+nation);
        return nation;
    }

    @Override
    public void info() {
        System.out.println("我是人");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    private static void showDesc(){
        System.out.println("我是可爱的人");
    }
}
