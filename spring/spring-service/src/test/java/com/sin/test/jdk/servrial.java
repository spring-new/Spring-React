package com.sin.test.jdk;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

public class servrial {
    @Test
    public void test() {
        String bigdecimal = "bigdecimal";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "name");
        System.out.println(jsonObject);
        jsonObject.put(bigdecimal, new BigDecimal(1111.0001));

        Map map1 = jsonObject.toJavaObject(Map.class);
        System.out.println(map1);
        Map<String, String> map = jsonObject.toJavaObject(Map.class);
        System.out.println(map);
    }

}
