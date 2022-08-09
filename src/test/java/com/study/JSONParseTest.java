package com.study;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author 匠承
 * @Date: 2022/8/9 14:06
 */
class JSONParseTest {

    String jsonString = "{    " +
            "   \"success\":\"true\",  " +
            "   \"returnAddress\":\"123\"," +
            "   \"object\":{\"a\":1}," +
            "\"array\":[1,2,3]" +
            " }";

    /**
     * 什么样的String才能被JSON.parseObject解析？
     */
    @Test
    public void parseObject() {
        JSONObject jsonObject = JSON.parseObject(jsonString);
        System.out.println(jsonObject);
        assertEquals("{\"a\":1}", jsonObject.getJSONObject("object"));
        assertEquals("true", jsonObject.getString("success"));
        assertEquals("123", jsonObject.getString("returnAddress"));

    }

    /**
     * 什么样的String才能被解析为数组
     */
    @Test
    public void parseArray() {
        JSONArray jsonArray = JSON.parseArray("[1,2,3]");
        System.out.println(jsonArray);
        assertNotEquals("[1,2,3]", jsonArray);
        assertEquals("[1,2,3]", jsonArray.toString());
        assertEquals(3, jsonArray.size());
    }

    /**
     * 从一个JSONObject中获取JSONArray
     */
    @Test
    public void parseArrayFromObject() {
        JSONObject jsonObject = JSON.parseObject(jsonString);
        JSONArray jsonArray = jsonObject.getJSONArray("array");
        System.out.println(jsonArray);
        assertNotEquals("[1,2,3]", jsonArray);
        assertEquals("[1,2,3]", jsonArray.toString());
        assertEquals(3, jsonArray.size());

    }
}