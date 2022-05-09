package com.sin.test.jdk;


public class LambdaDemo {
    public static void main(String[] args) {
        //��ʽһ
//        MyRunnable my = new MyRunnable();
//        Thread t = new Thread(my);
//        t.start();

        //��ʽ��
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("���̳߳���������");
//            }
//        }).start();

        //��ʽ��
        new Thread(() -> {
            System.out.println("���̳߳���������");
        }).start();
        //��ʽ����д
        Runnable r = () -> me();
        Thread t = new Thread(r);
        t.start();
    }

    public static void me() {
        System.out.println("���̳߳���������");
    }
}