package com.study.MockTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({B.class})
public class BTest {

    // 这里不使用@InjectMocks，因为@InjectMocks并不是mock对象。
    @Mock
    B b;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test1() {
        String res1 = b.fun();
        String res2 = b.method();
        Assert.assertNull(res1);
        Assert.assertNull(res2);
    }

    /**
     * 纵然B没有重写method()，但是依然可以mock出method()
     */
    @Test
    public void test2() {
        Mockito.doReturn("abc").when(b).method();
        String res = b.method();
        Assert.assertEquals("abc", res);
    }

    @Test
    public void test3(){


    }
}
