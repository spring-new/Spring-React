package com.bcm;

import com.bcm.dao.*;
import com.bcm.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/***********************************************
 * @className UserTests
 * @author lisir
 * @date 2020/3/19-16:09 
 * @version v1.0
 * @description
 ***********************************************/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {
    //注入对象
    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepositoryByQuery  userRepositoryByQuery;

    @Autowired
    private UserRepositoryCrud userRepositoryCrud;

    @Autowired
    private UserRepositoryPagandSort userRepositoryPagandSort;
    //jpa测试
    @Test
    public void testUserJpa(){
        //创建order        order by  name,age
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        //sort对象
        Sort sort = Sort.by(order);
        //排序的查询
        //对返回的结果进行了适配
        List<User> users = userJpaRepository.findAll(sort);
        //分页排序
       // Page<User> pages = userJpaRepository.findAll(PageRequest.of(0, 2, Sort.by(Sort.Direction.DESC, "name")));
       // List<User> list = pages.getContent(); //分页的数据
        for (User u: users) {
            System.out.println(u);
        }
    }


    //分页和排序
    //1排序
    @Test
    public void testSorting(){
        //创建order        order by  name,age
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        //sort对象
        Sort sort = Sort.by(order);
        //排序的查询
        Iterable<User> users = userRepositoryPagandSort.findAll(sort);
        for (User u: users) {
            System.out.println(u);
        }

    }
    //2分页
    @Test
    public void testPageing(){
        //创建Pageable  PageRequest(int page, int size)
        //page: 当前页码   从0页开始
        //size: 每页的记录数
        Pageable pageagle= PageRequest.of(0,2);
        //排序的查询
        Page<User> users = userRepositoryPagandSort.findAll(pageagle);
        System.out.println("总页码："+users.getTotalPages());
        System.out.println("总记录："+users.getTotalElements());
        System.out.println("当前页："+(users.getNumber()+1));
        List<User> list = users.getContent();
        for (User u: list) {
            System.out.println(u);
        }
    }
    //3分页+排序
    @Test
    public void testPageingAndSorting(){
        //排序
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        //创建Pageable  PageRequest(int page, int size)
        //page: 当前页码   从0页开始
        //size: 每页的记录数
        Pageable pageagle= PageRequest.of(0,2,sort);
        //排序的查询
        Page<User> users = userRepositoryPagandSort.findAll(pageagle);
        System.out.println("总页码："+users.getTotalPages());
        System.out.println("总记录："+users.getTotalElements());
        System.out.println("当前页："+(users.getNumber()+1));
        List<User> list = users.getContent();
        for (User u: list) {
            System.out.println(u);
        }
    }

    //实现CrudRepository接口的测试
    @Test
    public void testAddCRUD(){
        User user = new User();
        user.setName("lisir");
        user.setAge(19);
        user.setAddress("天津");
        userRepositoryCrud.save(user);
    }
    @Test
    public void testUpdateCRUD(){
        User user = new User();
        user.setId(4);
        user.setName("lisir1");
        user.setAge(25);
        user.setAddress("贵州");
        userRepositoryCrud.save(user);
    }
    @Test
    public void testDeleteCRUD(){
        userRepositoryCrud.deleteById(4);
    }
    @Test
    public void testSelectCRUD(){
        Iterable<User> users = userRepositoryCrud.findAll();
        for (User u: users) {
            System.out.println(u);
        }

    }


    //测试方法(添加用户)
    @Test
    public void testSaveUser(){
        User user = new User();
        user.setName("张明");
        user.setAge(21);
        user.setAddress("上海");
        userJpaRepository.save(user);
    }
    //测试Repository接口
    //List<User> findByName(String name);
    //按姓名和年龄查询(并列) where name=? and age=?
    //List<User> findByNameAndAge(String name,Integer age);
    //按姓名模糊查询
    //List<User> findByNameLike(String name);
    @Test
    public void testRepositoryByName(){
        List<User> user = userRepository.findByName("张三");
        for (User u : user) {
            System.out.println(u);
        }
    }
    @Test
    public void testRepositoryByNameAndAge(){
        List<User> user = userRepository.findByNameAndAge("张三",20);
        for (User u : user) {
            System.out.println(u);
        }
    }
    @Test
    public void testRepositoryByNameLike(){
        List<User> user = userRepository.findByNameLike("%张%");
        for (User u : user) {
            System.out.println(u);
        }
    }
    //@Query注解
    @Test
    public void testRepositoryByQuery(){
        List<User> users = userRepositoryByQuery.selectUserxxx("张三",20);
        System.out.println(users);
    }
    @Test
    @Transactional   //org.springframework.transaction.annotation.Transactional;
    public void testRepositoryByudate(){
        userRepositoryByQuery.updateUseryyyyy("张三丰",1);
    }
}
