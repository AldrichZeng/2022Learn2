package anotherPakcage;

import com.study.MockTest.B;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 * 在不同包下，调用protected方法是不行的。
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({B.class})
public class BTest {

    @InjectMocks
    B b;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        b= PowerMockito.spy(b);
    }

    @Test
    public void test1() throws Exception {
        String res = Whitebox.invokeMethod(b,"protectedMethod");
        Assert.assertEquals("A protected", res);

        res = Whitebox.invokeMethod(b, "protectedMethod2");
        Assert.assertEquals("B 重写的protected method", res);

        // 由下可见，虽然B没有重写protectedMethod()，但是依然可以mock。
        PowerMockito.doReturn("abc").when(b,PowerMockito.method(B.class, "protectedMethod")).withNoArguments();
        res = Whitebox.invokeMethod(b,"protectedMethod");
        Assert.assertEquals("abc",res);


        PowerMockito.doReturn("xyz").when(b, PowerMockito.method(B.class, "protectedMethod2")).withNoArguments();
        res = Whitebox.invokeMethod(b, "protectedMethod2");
        Assert.assertEquals("xyz", res);


    }
}
