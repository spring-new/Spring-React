package com.bcm.dao;


import org.springframework.data.repository.PagingAndSortingRepository;

import java.spring.entity.User;

/***********************************************
 * @className UserRepositoryPagandSort
 * @author lisir
 * @date 2020/3/24-14:34 
 * @version v1.0
 * @description
 ***********************************************/
public interface UserRepositoryPagandSort extends PagingAndSortingRepository<User,Integer> {
}
