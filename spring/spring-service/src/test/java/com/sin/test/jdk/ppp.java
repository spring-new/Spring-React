package com.sin.test.jdk;

import java.io.*;
import java.util.*;

public class ppp {
    public static void main(String[] args) throws IOException {
        ArrayList<List<String>> list = new <String>ArrayList();
        HashMap<List<String>, List<String>> map = new HashMap<>();
        HashSet<String> hmap = new HashSet<>();

        String path = "C:\\Users\\Wcs\\Desktop\\��̨\\����\\ǩ��\\ǩ������\\20220407000064\\contInfo\\20220407000064.txt";
        //�ַ����������ж�ȡ��������
        BufferedReader reader = null;
        //ÿһ������
        String tempString = null;
        int line = 1;
        int i = 0;
        File file = new File(path);
        FileInputStream input = new FileInputStream(file);
        reader = new BufferedReader(new InputStreamReader(input));
        while ((tempString = reader.readLine()) != null) {
            if (tempString != null && !"".equals(tempString)) {
                List<String> contLists = Arrays.asList(tempString.split("\\|"));
                list.add(contLists);
                i++;
                for (String cont : contLists) {
                    hmap.add(cont);
                }

                map.put(contLists, contLists);
            }

        }
        System.out.println("����ү��" + list.size());
        System.out.println("����ү��" + map);
        System.out.println(hmap.size());
    }
}
