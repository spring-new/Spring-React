package com.sin.test.jdk;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.Semaphore;

public class Ta {
    static class Tcc {
        public static void main(String[] args) {
            User user = new User();
            user.setId(1);
            user.setName(2);

            Person person = new Person();
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            //hashMap.put("person", person);

            hashMap.put("hashUser", user);
            User users = (User) hashMap.get("hashUser");
            users.setId(3);
            users.setName(4);
            System.out.println(hashMap);
            Person person1 = (Person) hashMap.get("person");
            System.out.println(person1);
            abbb:
            for (int i = 0; i < 7; i++) {
                System.out.println(i);
            }

  /*          String c = "1";
            if ("1,2".contains(c)) {
                System.out.println("wdd");
            } else {
                System.out.println("ddd");
            }*/

        }

        @Test
        public void main1(String[] args) {
            User user = new User();
            user.setId(1);
            user.setName(Integer.parseInt("sss"));

            first:
            for (int i = 0; i < 7; i++) {
                System.out.println(i);
            }


            HashMap<Object, User> hashMap = new HashMap<Object, User>();
            hashMap.put("user", user);
            User users = hashMap.get("user");
            users.setId(2);
            users.setName(Integer.parseInt("3"));
            System.out.println(hashMap);
        }
    }

    class Pool {
        private static final int MAX_AVAILABLE = 100;
        private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

        public Object getItem() throws InterruptedException {
            available.acquire();
            return 1;
        }

        public void putItem(Object x) {
            if (1 == 1) available.release();
        } // Not a particularly efficient data structure; just for demo protected Object[] items = ... whatever kinds of items being managed protected boolean[] used = new boolean[MAX_AVAILABLE]; protected synchronized Object getNextAvailableItem() { for (int i = 0; i < MAX_AVAILABLE; ++i) { if (!used[i]) { used[i] = true; return items[i]; } } return null; // not reached } protected synchronized boolean markAsUnused(Object item) { for (int i = 0; i < MAX_AVAILABLE; ++i) { if (item == items[i]) { if (used[i]) { used[i] = false; return true; } else return false; } } return false; } }
    }

    class a {

    }
}