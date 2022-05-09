package ide.eclipse.service;

import java.lang.reflect.Field;
import java.spring.entity.Student;
import java.spring.entity.User;
import java.util.HashMap;

public class TestUser {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        method3();

    }
    public void pass(User user){
       // user = new User();
        user.setName("WCS");

        System.out.println("print in pass , user is " + user);
    }

    private static void method1() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        //        void set?(Object obj, Object value)：给obj对象的成员变量赋值为value
        //1.获取class对象
        Class clazz = Class.forName("ide.eclipse.entity.Student");

        //2.获取name这个Field对象
        Field field = clazz.getField("name");

        //3.利用set方法进行赋值.
        //3.1先创建一个Student对象
        Student student = (Student) clazz.newInstance();
        //3.2有了对象才可以给指定对象进行赋值
        field.set(student,"zhangsan");

        System.out.println(student);
    }
    private static void method3() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        HashMap hashMap=new HashMap<>();
        User user = new User();
        user.setGender("男");
        user.setName("张山");
        hashMap.put("User",user);

        //        void set?(Object obj, Object value)：给obj对象的成员变量赋值为value
        //1.获取class对象
        Class clazz = Class.forName("ide.eclipse.service.Reflect");

        //2.获取name这个Field对象
        Field field = clazz.getField("hashMap");

        //3.利用set方法进行赋值.
        //3.1先创建一个Student对象
        Reflect reflect = (Reflect) clazz.newInstance();
        //3.2有了reflect对象才可以给指定对象进行赋值

        field.set(reflect,hashMap);

        System.out.println(reflect);
    }
}
