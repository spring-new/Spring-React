package com.bcm;

//import com.bcm.dao.UserRepositorySpec;
import com.bcm.dao.UserRepositorySpec;
import com.bcm.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/***********************************************
 * @className UserTestsSpec
 * @author lisir
 * @date 2020/3/24-15:24 
 * @version v1.0
 * @description
 ***********************************************/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class UserTestsSpec {
    //注入对象
    @Autowired
    private UserRepositorySpec userRepositorySpec;
    //单条件查询
    @Test
    public void testSpec(){
        //Specification对象
       Specification<User> sepc =new Specification<User>() {
           //查询姓名=“张三” where  name="张三" and /or between ...
           /**
            * Predicate  查询条件
            * 参数：
            * root: 对查询对象的属性封装
            * query: 查询各部分的信息   select order by ....
            * cb: 条件的构造器，定义条件
            */
           @Override
           public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
               Predicate pre = cb.equal(root.get("name"), "张三丰");
               return pre;
           }
       };
        List<User> users = userRepositorySpec.findAll(sepc);
        System.out.println(users);
    }
    //多条件查询，   分页，排序
    @Test
    public void testSpecDuo(){
        //Specification对象
        Specification<User> sepc =new Specification<User>() {
            //查询姓名=“张三” where  name="张三" and  age=20 ..
            //where  name like"张%" and  age=20 ..
            /**
             * Predicate  查询条件
             * 参数：
             * root: 对查询对象的属性封装
             * query: 查询各部分的信息   select order by ....
             * cb: 条件的构造器，定义条件
             */

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //where  name="张三" and  age=20
                //Predicate pre = cb.equal(root.get("name"), "张三丰");
                //where  name like"张%" and  age=20 ..
                Predicate pre = cb.like(root.get("name"), "张%");
                Predicate pre1 = cb.equal(root.get("age"), 20);
               //Predicate predicate = cb.and(pre, pre1);
                //where  name like"张%" or  age=20 ..
                Predicate predicate = cb.or(pre, pre1);
                /*
                //拓展部分
                 //where  (name="张三" and  age=20 )  or (id=1) .....
                Predicate p1 = cb.and(pre, pre1);  //name="张三" and  age=20 )
                Predicate p2 = cb.equal(root.get("id"), 1); //(id=1)
                Predicate p = cb.or(p1, p2);
                 */
                return predicate;

            }
        };
        //分页或排序
       // List<User> users = userRepositorySpec.findAll(sepc, Pageable对象 );
        List<User> all = userRepositorySpec.findAll(sepc);

        System.out.println(all);
    }
}
