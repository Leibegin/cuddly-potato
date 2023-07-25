package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    //查询，可以实现登录功能
    @Select("SELECT * FROM user WHERE name = #{name} AND password = #{password}")
    User getInfo(@Param("name") String name, @Param("password") String password);
    //查询用户名，实现禁止相同用户名注册功能
    @Select("SELECT * FROM user WHERE name = #{name}")
    User wolfInfo(@Param("name") String name);
    //多个参数要加@Param修饰
    //增加，可以实现注册功能
    @Insert("insert into user(name,password)values(#{name},#{password})")
    void saveInfo(@Param("name") String name, @Param("password") String password);
    //查询id，实现通过id寻找用户功能
    @Select("SELECT * FROM user WHERE id = #{id}")
    User leafInfo(@Param("id") Integer id);
}