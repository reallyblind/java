package com.blind.exer1;

import java.util.List;

/**
 * @author blind
 * @create 2022-09-20-11:05
 *  * 定义一个测试类：
 *  * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方法来操作 User 对象，
 *  * 使用 Junit 单元测试类进行测试
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("1001",new User(1001,34,"jackChou"));
        dao.save("1002",new User(1002,20,"昆凌"));
        dao.save("1003",new User(1003,25,"蔡依林"));

        dao.update("1003",new User(1003,30,"方文山"));

//        dao.delete("1002");

        List<User> list =  dao.list();
//        System.out.println(list);

        list.forEach(System.out::println);

    }

}
