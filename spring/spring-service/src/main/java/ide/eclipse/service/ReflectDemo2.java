package ide.eclipse.service;

import java.lang.reflect.Field;
import java.spring.entity.Student;

public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
//        Object get?(Object obj) �����ɸ� Field��ʾ���ֶ���ָ�������ϵ�ֵ��
        method1();

        //method2();

    }

    private static void method2() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        //1.��ȡclass����
        Class clazz = Class.forName("ide.eclipse.entity.Student");

        //2.��ȡ��Ա����Field�Ķ���
        Field field = clazz.getDeclaredField("money");

        //3.ȡ��һ�·��ʼ��
        field.setAccessible(true);

        //4.����get��������ȡֵ
        //4.1����һ������
        Student student = (Student) clazz.newInstance();
        //4.2��ȡָ�������money��ֵ
        Object o = field.get(student);

        //5.��ӡһ��
        System.out.println(o);
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
}
