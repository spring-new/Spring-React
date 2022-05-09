package ide.eclipse.service;

import java.util.HashMap;
import java.util.Map;

public class TestSignReNewMarkBL implements Runnable {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("hello " + name);
    }

    public static void main(String[] args) {
        main3();
    }

    public static void main3() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("357", "54");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String risk = entry.getKey();
            if (risk instanceof String) {
                String a = entry.getKey();
                String b = entry.getValue();
                System.out.println(a + "  " + b);
            }
        }
/*    List<User> users = new ArrayList<>();

        HashMap hashMap=new HashMap<>();
        User user = new User();
        user.setGender("ÄĞ");
        user.setName("ÕÅÉ½");

        users.add(user);
        User user2 = new User();
        user2.setGender("Å®");
        user2.setName("»ÆÃ·Ï·");

        users.add(user2);

        user2.setGender("ÄÈÄÈ");
        user2.setName("àÖàÖàÖ");
        users.add(user2);
        System.out.println(users);
        hashMap.put("Users",users);
        SignReNewMarkBL signReNewMarkBL = new SignReNewMarkBL();
        signReNewMarkBL.setHashMap(hashMap);
        Thread thread = new Thread(signReNewMarkBL);
        thread.start();*/

    }

}