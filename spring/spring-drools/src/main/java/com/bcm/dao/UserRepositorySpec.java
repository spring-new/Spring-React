package com.bcm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.spring.entity.User;

/***********************************************
 * @className UserRepositorySpec
 * @author lisir
 * @date 2020/3/24-15:22 
 * @version v1.0
 * @description 同时实现分页，排序，多条件查询( 常用 )
 ***********************************************/
public interface UserRepositorySpec extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
   // List<User> findByNameAndAge(String name, Integer age);
}
