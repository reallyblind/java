package com.blind.java1;

import java.io.Serializable;

/**
 * @author blind
 * @create 2022-10-02-16:08
 */
public class Creature <T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }
    public void eat(){
        System.out.println("生物吃东西");
    }
}
