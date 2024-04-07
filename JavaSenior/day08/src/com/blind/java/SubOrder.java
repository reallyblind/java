package com.blind.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author blind
 * @create 2022-09-19-14:13
 */
public class SubOrder extends Order<Integer>{//SubOrder：不是泛型类

    public static <E> List<E> copyFromArrarToList(E[] arr){//少最开始的<E>会把E以为是一个类型
        ArrayList<E> list = new ArrayList<>();

        for(E e:arr){
            list.add(e);
        }
        return list;

    }
}
