package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author blind
 * @create 2022-11-08-9:41
 */
public interface UserMapper {
    List<User> selectAll();

    @Select("select * from tb_user where id = #{id}")
    User selectById(int id);
}
