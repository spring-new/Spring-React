package com.bcm.dao;



import org.springframework.data.repository.Repository;

import java.spring.entity.User;
import java.util.List;

/***********************************************
 * @className UserRepository
 * @author lisir
 * @date 2020/3/23-10:43 
 * @version v1.0
 * @description
 * T 操作实体类的类型
 * ID 主键类型
 ***********************************************/
public interface UserRepository extends Repository<User,Integer> {
    //提供了方法名称命名查询方式
    //遵循驼峰规则 ：findBy(关键字) + 属性名 + 查询条件
    //按姓名查询用户
    List<User> findByName(String name);
    //按姓名和年龄查询(并列) where name=? and age=?
    List<User> findByNameAndAge(String name, Integer age);
    //按姓名模糊查询(张姓头)
    List<User> findByNameLike(String name);
    List<User> findByNameStartingWith(String name);  //类似 like "张%"
}
