package ide.eclipse.service;

import ide.eclipse.entity.DemoModel;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

public class testCSDN {
    public static void main(String[] args) throws Exception{
        DemoModel object = new DemoModel();
        // ��ȡ˽�б���
        Field field;
        try {
            field = object.getClass().getDeclaredField("name");
        } catch (NoSuchFieldException ex) {
            // ���಻���ڸñ�����ô����ȥ�����ȡ����
            field=object.getClass().getSuperclass().getDeclaredField("name");
        }
        // ǿ����Ȩ����˽�г�Ա����
        AccessibleObject f = null;
        f.setAccessible(true);
        //f.set(object, "Jack");
        System.out.println(object.getName());// ��� Jack
    }

}
