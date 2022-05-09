package com.bcm.dao;


import org.springframework.data.repository.CrudRepository;

import java.spring.entity.User;

/***********************************************
 * @className UserRepositoryCrud
 * @author lisir
 * @date 2020/3/23-11:53 
 * @version v1.0
 * @description
 ***********************************************/
public interface UserRepositoryCrud extends CrudRepository<User,Integer> {
}
