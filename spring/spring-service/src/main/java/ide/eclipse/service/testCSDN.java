package ide.eclipse.service;

import ide.eclipse.entity.DemoModel;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

public class testCSDN {
    public static void main(String[] args) throws Exception{
        DemoModel object = new DemoModel();
        // 获取私有变量
        Field field;
        try {
            field = object.getClass().getDeclaredField("name");
        } catch (NoSuchFieldException ex) {
            // 子类不存在该变量那么尝试去父类获取变量
            field=object.getClass().getSuperclass().getDeclaredField("name");
        }
        // 强行授权访问私有成员变量
        AccessibleObject f = null;
        f.setAccessible(true);
        //f.set(object, "Jack");
        System.out.println(object.getName());// 输出 Jack
    }

}
