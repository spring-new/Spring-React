

package ide.eclipse.service;


import java.lang.reflect.Field;

public class myfl1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
//        mothed1();
//        mothed2();
//        mothed3();
        //��ȡ˽�еĳ�Ա����
        Class clazz = Class.forName("ide.eclipse.entity.Student");
        Field field = clazz.getDeclaredField("money");
        System.out.println(field);


    }

    private static void mothed3() throws ClassNotFoundException, NoSuchFieldException {
        //���ص���������Ա����
        // ��Ҫ��ȡ�ĳ�Ա������������ʵ���ڵ�
        //�ұ�����public���ε�.

        Class clazz = Class.forName("ide.eclipse.entity.Student");
        Field field = clazz.getField("name");
        System.out.println(field);
    }

    private static void mothed2() throws ClassNotFoundException {
        //��ȡ���еĳ�Ա����
        Class clazz = Class.forName("ide.eclipse.entity.Student");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }

    //��ȡ���й����ĳ�Ա����
    private static void mothed1() throws ClassNotFoundException {
        //��ȡclass����
        Class clazz = Class.forName("ide.eclipse.entity.Student");
        //��ȡ���й�����Ա����
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }
}

