package com.sin.test;



import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SwitchString {
    public static void main(String[] args) {





/*
        int i = 3;
        int s = 5;
        for (int k = 0; k < 5; k++) {

            i = 3;
            for (int j = 1; j < 10; j++) {
                if (j == i) {
                    s++;
                    break;

                }
            }
            if (s > 5) {
                System.out.println(":"+k+":" + 6);
            }
        }
*/





        /*

        HashMap<String, Boolean> contnos = new HashMap<String, Boolean>();
        contnos.put("1", true);
        contnos.put("2", true);
        contnos.put("3", true);
        contnos.put("4", false);
        contnos.put("5", true);
        contnos.put("6", true);
        contnos.put("3", false);

        System.out.println("===================");
        for (Map.Entry<String, Boolean> entry : contnos.entrySet()) {
            if (entry.getValue()) {
                System.out.println("key is " + entry.getKey());
                System.out.println("value is " + entry.getValue());

            }
        }*/


//        if (contnos.put("123")) {
//            System.out.println("holle world");
//        }




        /*
        HashSet<String> contnos = new HashSet<String>();
        contnos.add("123");
        contnos.add("456");
        contnos.add("678");
        contnos.add("123");
        if (contnos.contains("123")){
            System.out.println( "holle world");
        }


        */









/*        conts.add("123");
        conts.add("123");
        conts.add("123");
        conts.add("123");
        conts.add("123");
        conts.add("124");


        for (int i = 0; i < 10; i++) {
            if (conts.contains("124")) {
                System.out.println("wcs");

            }
        }
        System.out.println("===========");
        for (int i = 0; i < conts.size(); i++) {
            System.out.println("conts" + conts);
        }
        System.out.println("===========");

        for (String s : conts) {
            System.out.println(s);

        }

        */

/*        switch (param) {
            // 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
            // 也不是进入这里
            case "null":
                System.out.println("it's null");
                break;
            // 也不是进入这里
            default:
                System.out.println("default");
        }*/

/*        for (int i = 0; i < 10; i++) {

            if (i == 6) {
                return;
            }
            System.out.println(i);
        }*/
        /*

        String num1 = "9.78";
        double num2 = 9.78;
        double num3 = Double.parseDouble(num1);
        System.out.println(Double.parseDouble(num1));


        String num = "9.78";
        BigDecimal bigDecimal = new BigDecimal(num);

        // bigDecimal=bigDecimal.multiply(new BigDecimal("100"));
        if (num2 == num3) {
            System.out.println("        System.out.println(Double.parseDouble(num1));\n");
        }
        System.out.println(bigDecimal);
        */
/*        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");    //设置日期格式

        Date begin = fmt.parse("20170730"); //开始日期

        Date end = fmt.parse("20170830"); //结束日期

        try {
            Date bt=df.parse(begin );
            Date et=df.parse(end );
            if (bt.before(et)){
                bt日期小于于et日期
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
    }

    @Test
    public void service() {

        HashMap<String, Object> signCheckData = new HashMap<>();
        signCheckData.put("PlanType", 1);
        signCheckData.put("IsNoMoneyPolicyFlag", 2);
        signCheckData.put("PolicySource", 3);
        signCheckData.put("BigFlag", 4);
        signCheckData.put("mOverFlag", 5);

        signCheck(signCheckData);
        for (Map.Entry<String, Object> entry : signCheckData.entrySet()) {
            System.out.println("key is " + entry.getKey());
            System.out.println("value is " + entry.getValue());
        }
        System.out.println(signCheckData);

        check(signCheckData);
        for (Map.Entry<String, Object> entry : signCheckData.entrySet()) {

                System.out.println("key is " + entry.getKey());
                System.out.println("value is " + entry.getValue());
        }

        System.out.println(signCheckData.get("PlanType"));

    }

    private boolean check(HashMap<String, Object> signCheckData) {
        signCheckData.put("1", 11);
        signCheckData.put("12", 11);
        signCheckData.put("13", 11);
        signCheckData.put("14", 11);
        signCheckData.put("15", 11);
        signCheckData.put("16", 11);
        return false;
    }

    private void signCheck(HashMap<String, Object> signCheckData) {
        Object ccc = 111;
        signCheckData.put("adsa", 6);
    }

    ;
}

