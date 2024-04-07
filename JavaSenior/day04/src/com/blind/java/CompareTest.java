package com.blind.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一、 说明：Java中的对象，正常情况下，只能进行：==或！=。不能使用>或<的
 *          但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。
 *          如何实现？使用两个接口中的任何一个接口：Comparable 或 Comparator
 *
 * 二、Comparable接口与Comparator的使用
 *  Comparable接口的方式一旦指定，保证comparable接口实现类的对象在任何位置都可以比较大小
 *  Comparator接口属于临时性的比较
 *
 * @author blind
 * @create 2022-08-24-9:00
 */
public class CompareTest {
    /*
    Comparable接口的使用举例：自然排序
    1.像String、包装类等实现了Comparable接口、重写了CompareTo(obj)方法，给出了比较两个对象的方法
    2.像String、包装类重写CompareTo（）方法以后，进行了从小到大的排序
    3.重写CompareTo(obj)规则：
        如果当前对象this大于形参对象obj，则返回正数，如果this小于obj，返回负数。相等返回0
    4.对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法
      在compareTo(obj)方法中指明如何排序

     */
    @Test
    public void test1(){
        String [] arr = new String[]{"AA","CC","KK","MM","GG","jj","DD"};

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lonovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);
        arr[4] = new Goods("microMouse",65);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /*
    Comparator接口的使用：定制排序
    1.背景：
        当元素的类型没有实现java.lang.Comparable接口又不方便修改代码，
        或者实现了java.lang.Comparable接口的规则不符合当前的操作，那么
        可以考虑使用Comparator的对象来排序
    2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小：如果方法返回正整数，则表示o1>o2
        负数,o1<o2，0，o1=o2

     */
    @Test
    public void test3(){
        String [] arr = new String[]{"AA","CC","KK","MM","GG","jj","DD"};


        Arrays.sort(arr, new Comparator<String>() {
            //字符串从大到小
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void test4(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lonovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);
        arr[4] = new Goods("microMouse",65);

        Arrays.sort(arr, new Comparator<Goods>() {
            //按照产品名称从低到高，再按照价格从高到低
            @Override
            public int compare(Goods o1, Goods o2) {
                if(o1.getName().compareTo(o2.getName())!=0){
                    return o1.getName().compareTo(o2.getName());

                }
                else return -Double.compare(o1.getPrice(),o2.getPrice());

            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
