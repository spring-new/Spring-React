package com.sin.test.jdk;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        test t = new test();
t.ifelse();
        // t.said();
/*        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sf.parse("2015-12-01");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            System.out.println(calendar.get(Calendar.YEAR));
            System.out.println(calendar.get(Calendar.MONTH) + 1);
            System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        } catch ( ParseException e) {
            e.printStackTrace();
        }*/

/*
        double a = 0.001;
        Double b = 0.0010;
        if (a==b) {
        //if (Double.doubleToLongBits(a) == Double.doubleToLongBits(b) ) {
            System.out.println("yyyy");
        }else {
            System.out.println("dddddddddd");
        }

*/

    }

    public void ifelse() {
        String i = "23";


        if ("2".equals(i)) {
            System.out.println("ifffffff222222222222");
        }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             else {
            System.out.println("else2222222222222");
        }
    }

    public void said() {
        String sa = "sa";
        String stringObj = "�չ�����/����/�����չ���/��";
        System.out.println(stringObj);
        try {
            Thread.sleep(1000);

        } catch (Exception e) {
            System.out.println(e);
        }
        String stringObj2 = "�չ�����/����/�����չ���/��";
        System.out.println(stringObj2);
//�滻����֡��չš�Ϊ���й���
//�������滻������ַ�
//ԭ�ַ���stringObj��ֵû�иı�
        String newstr = stringObj.replace("/", "-");
        System.out.println(newstr);

    }
}


