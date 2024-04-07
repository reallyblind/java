package com.blind.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection接口中声明的方法的测试
 *
 * 向Collection接口的实现类的对象中添加数据obj时，要求obj所在类重写equals（）
 *
 * @author blind
 * @create 2022-08-26-11:52
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        Person p = new Person("Jerry", 20);
        coll.add(p);

        System.out.println(coll);
        //1.contains(Object obj):判断当前集合中是否包含obj,调用对象的equals方法
        //我们在判断时会调用obj对象所在类的equals方法
        boolean contains = coll.contains(123);
        System.out.println(contains);

        System.out.println(coll.contains(new String("Tom")));//
        System.out.println(coll.contains(p));//
        System.out.println(coll.contains(new Person("Jerry", 20)));//

        //2.containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中
        Collection coll1 = Arrays.asList(123,4567);
        System.out.println(coll.containsAll(coll1));

    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        Person p = new Person("Jerry", 20);
        coll.add(p);

        //3.remove(Object obj):从当前集合中移除obj元素,返回bollean型
        coll.remove(1234);
        System.out.println(coll);

        coll.remove(new Person("Jerry",20));

        //4.removeAll(Collection coll1):差集：从当前集合中移除coll1中所拥有的元素
        Collection coll1 = Arrays.asList(123,4567);
        coll.removeAll(coll1);
        System.out.println(coll);

    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //5.retainAll():求交集：获取当前集合和coll1集合的交集，并把当前集合修改
        Collection coll1 = Arrays.asList(123,456,789);
//        coll.retainAll(coll1);
        System.out.println(coll);

        //6.equals(Object obj):比较两个类是否相等,要想返回true，需要当前集合和形参集合的元素都相同
        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(456);
        coll2.add(new Person("Jerry",20));
        coll2.add(new String("Tom"));
        coll2.add(false);

        System.out.println(coll.equals(coll2));
    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合 ----> 数组:toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //拓展：数组 --> 集合
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);//[AA,BB,CC]

        List<int[]> arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1);//地址

        List arr2 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr2.size());//1

        List arr3 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr3.size());//2

        //9.iterator():返回Iterator接口的实例，用于遍历集合。放在IteratorTest.java中测试



    }


}
