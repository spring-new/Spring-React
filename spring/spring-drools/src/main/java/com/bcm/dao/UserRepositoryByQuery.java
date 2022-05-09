package com.bcm.dao;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.spring.entity.User;
import java.util.List;

/***********************************************
 * @className UserRepositoryByQuery
 * @author lisir
 * @date 2020/3/23-11:06 
 * @version v1.0
 * @description
 * @Query注解 方法随意定义
 ***********************************************/
public interface UserRepositoryByQuery extends Repository<User,Integer> {

    // sql     nativeQuery=true   hibernate 不进行语句转换 执行sql
    //nativeQuery=ｆalse   默认值   hql 查询   hibernate 进行转换 sql
    //查询
    @Query(value = "select * from t_user where name = ? and age = ?",nativeQuery = true)
    List<User> selectUserxxx(String name, Integer age);   //参数的顺序要和占位符的顺序必须一致

    //更新根据ID 修改姓名
    @Query(value = "update t_user set name = ? where id = ?",nativeQuery = true)
    @Modifying
    void updateUseryyyyy(String name, Integer id);


}
