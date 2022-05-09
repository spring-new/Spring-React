package com.bcm.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import java.spring.entity.User;

/***********************************************
 * @className UserJpaRepository
 * @author lisir
 * @date 2020/3/19-16:12 
 * @version v1.0
 * @description
 * <T, ID>
 *  T: 操作的实的实体类 User
 *  ID：主键的类型  Integer
 ***********************************************/
public interface UserJpaRepository extends JpaRepository<User,Integer> {
}
