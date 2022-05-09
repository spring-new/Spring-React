package com.bcm.interfac;

import com.bcm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/*
 *  T: 操作的实的实体类 User
 *  ID：主键的类型  Integer
 */
public interface UserInterface extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
    //提供了方法名称命名查询方式
    //遵循驼峰规则 ：findBy(关键字) + 属性名 + 查询条件
    //按姓名查询用户
}
