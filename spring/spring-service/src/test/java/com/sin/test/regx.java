package com.sin.test;

import java.util.Arrays;

public class regx {
    public static void main(String args[]) {
        String str = new String("Welcome-to-Runoob");

        System.out.println("- �ָ�������ֵ :" );
        for (String retval: str.split("-")){
            System.out.println(retval);
        }

        System.out.println("");
        System.out.println("- �ָ������÷ָ��������ֵ :" );
        for (String retval: str.split("-", 2)){
            System.out.println(retval);
        }

        System.out.println("");
        String str2 = new String("www.runoob.com");
        System.out.println("ת���ַ�����ֵ  8888888888 :" );
        for (String retval: str2.split("\\.",0)){
            System.out.println(retval);
        }

        System.out.println("");
        String str3 = new String("acount=? and uu =? or n=?");
        System.out.println("����ָ�������ֵ :" );
        for (String retval: str3.split("and|or")){
            System.out.println(retval);
        }
    }


}
