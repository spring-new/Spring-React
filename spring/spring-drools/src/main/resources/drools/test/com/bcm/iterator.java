package com.bcm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class iterator {

    public static void main(String[] args) {

// TODO Auto-generated method stub


        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("c");
        list.add("c");
        list.add("c");
        list.add("c");
        list.add("c");
        list.add("c");
        list.add("c");
        list.add("c");
        list.add("c");
        list.add("c");
        list.add("c");
        list.add("c");
/*         //1:通过索引遍历list
        for(int i=0;i<list.size();i++){
            System.err.println("1:"+list.get(i));   //err：输出换行
            System.out.print("2:"+list.get(i));    //out：输出不换行
        }*/
        String str = "";
        //2：迭代器遍历
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            str += it.next();
            System.out.println(str);
            //   it.remove();
        }
        System.out.println("=========================");

        System.out.println("str:::::::"+str);









        //2：迭代器遍历
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            str += it.next();
            System.out.println(str);
            //   it.remove();
        }
        System.out.println("=========================");

        System.out.println("str:::::::"+str);
//      //while形式
//        Iterator<String> i=list.iterator();
//        while(i.hasNext()){
//            String s=i.next();
//            System.out.print(s);
//        }
//

    }
}
class cc {

    public static void main(String[] args) {
        String next="";
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("b");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            next += iterator.next();
        }

        System.out.println(next);

    }
}