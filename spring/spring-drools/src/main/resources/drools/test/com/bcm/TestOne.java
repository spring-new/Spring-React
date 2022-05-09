package com.bcm;

import com.bcm.dao.UserJpaRepository;
import com.bcm.entity.Blog;
import com.bcm.entity.Roles;
import com.bcm.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/***********************************************
 * @className TestOne
 * @author lisir
 * @date 2020/3/24-16:23 
 * @version v1.0
 * @description
 ***********************************************/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOne {

    //主要是操作用户
    @Autowired
    private UserJpaRepository userJpaRepository;
    //添加用户同时要添角色
    @Test
    public void testOneToMany(){
        //用户对象
        User u = new User();
        u.setName("tom");
        u.setAge(19);
        u.setAddress("北京");
        //角色对象
        Roles r = new Roles();
        r.setRolename("管理员");
        //关联
        r.getUsers().add(u);  //角色关联了用户
        u.setRoles(r);  //用户关联角色
        //保存
        userJpaRepository.save(u);
    }
    @Test
    public  void  testOneBlog(){
        Blog  Blog= new Blog();


    }

    public static void main(String[] args) {
        String str="1234";
        longestPalindrome(str);
    }
    public static String longestPalindrome(String s) {
        if (s.equals(""))
            return "";
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                /**********修改的地方*******************/
                if (arr[i][j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + arr[i][j] - 1 == i) { //判断下标是否对应
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                    /*************************************/
                }
            }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }
}
