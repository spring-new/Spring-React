package com.sin.test.jdk;


public class LambdaDemo {
    public static void main(String[] args) {
        //方式一
//        MyRunnable my = new MyRunnable();
//        Thread t = new Thread(my);
//        t.start();

        //方式二
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("多线程程序启动了");
//            }
//        }).start();

        //方式三
        new Thread(() -> {
            System.out.println("多线程程序启动了");
        }).start();
        //方式三简写
        Runnable r = () -> me();
        Thread t = new Thread(r);
        t.start();
    }

    public static void me() {
        System.out.println("多线程程序启动了");
    }
}