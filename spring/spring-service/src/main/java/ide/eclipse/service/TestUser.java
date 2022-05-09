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
        //        void set?(Object obj, Object value)����obj����ĳ�Ա������ֵΪvalue
        //1.��ȡclass����
        Class clazz = Class.forName("ide.eclipse.entity.Student");

        //2.��ȡname���Field����
        Field field = clazz.getField("name");

        //3.����set�������и�ֵ.
        //3.1�ȴ���һ��Student����
        Student student = (Student) clazz.newInstance();
        //3.2���˶���ſ��Ը�ָ��������и�ֵ
        field.set(student,"zhangsan");

        System.out.println(student);
    }
    private static void method3() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        HashMap hashMap=new HashMap<>();
        User user = new User();
        user.setGender("��");
        user.setName("��ɽ");
        hashMap.put("User",user);

        //        void set?(Object obj, Object value)����obj����ĳ�Ա������ֵΪvalue
        //1.��ȡclass����
        Class clazz = Class.forName("ide.eclipse.service.Reflect");

        //2.��ȡname���Field����
        Field field = clazz.getField("hashMap");

        //3.����set�������и�ֵ.
        //3.1�ȴ���һ��Student����
        Reflect reflect = (Reflect) clazz.newInstance();
        //3.2����reflect����ſ��Ը�ָ��������и�ֵ

        field.set(reflect,hashMap);

        System.out.println(reflect);
    }
}
