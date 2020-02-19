package com.ucd.micro.monitor.lambda;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * @ClassName: Tools
 * @Description: TODO
 * @Author: Crayon
 * @CreateDate: 2019/11/7 2:02 下午
 * @Version 1.0
 * @Copyright: Copyright©2018-2019 BJCJ Inc. All rights reserved.
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Tools {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public Tools() {
    }

    public static String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public static <T> T jsonToObject(String str, Class<T> T) {
        try {
            return objectMapper.readValue(str, T);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static <T> Map<String, Object> json2map(String jsonStr) throws Exception {
        return (Map) JSON.parseObject(jsonStr, Map.class);
    }

    public static <T> T map2obj(Map<?, ?> map, Class<T> clazz) throws Exception {
        return JSON.parseObject(JSON.toJSONString(map), clazz);
    }

    public static <T> T map2Listobj(Map<?, ?> map, Class<T> clazz) throws Exception {
        String str = JSON.toJSONString(map);
        return JSON.parseObject(str, clazz);
    }
}
