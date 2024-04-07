package com.blind.java4;

/**
 * @author blind
 * @create 2022-10-05-21:40
 */
public class Girl {
    private String name;

    public Girl() {
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Girl(String name) {
        this.name = name;
    }
}
