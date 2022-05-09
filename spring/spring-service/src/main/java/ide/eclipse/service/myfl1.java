

package ide.eclipse.service;


import java.lang.reflect.Field;

public class myfl1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
//        mothed1();
//        mothed2();
//        mothed3();
        //获取私有的成员变量
        Class clazz = Class.forName("ide.eclipse.entity.Student");
        Field field = clazz.getDeclaredField("money");
        System.out.println(field);


    }

    private static void mothed3() throws ClassNotFoundException, NoSuchFieldException {
        //返回单个公共成员变量
        // 想要获取的成员变量必须是真实存在的
        //且必须是public修饰的.

        Class clazz = Class.forName("ide.eclipse.entity.Student");
        Field field = clazz.getField("name");
        System.out.println(field);
    }

    private static void mothed2() throws ClassNotFoundException {
        //获取所有的成员变量
        Class clazz = Class.forName("ide.eclipse.entity.Student");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }

    //获取所有公共的成员方法
    private static void mothed1() throws ClassNotFoundException {
        //获取class对象
        Class clazz = Class.forName("ide.eclipse.entity.Student");
        //获取所有公共成员变量
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }
}

