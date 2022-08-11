package com.study;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 匠承
 * @Date: 2022/8/11 09:49
 */
class ListSetTest {
    @Test
    public void test(){
        List<String> list = new ArrayList<>();
        list.set(0,"123");
        System.out.println(list);
    }

}