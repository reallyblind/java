package com.blind.java;

import java.util.Objects;

/**
 * @author blind
 * @create 2022-08-28-20:10
 */
public class User implements Comparable{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("User equals()");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User user = (User)o;
            return this.name.compareTo(user.name);
        }else{
            throw new RuntimeException("输入的类型不匹配");
        }
    }
}
