import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * 参数化(测试数据):
 * 1.xml中体现入参数据;
 * 2.直接@DataProvider注解提供
 *
 * @author Liping Fu

 */
public class DataProviderTest {

    @Test
    @Parameters({"add1", "add2", "result"})
    public void testAdd1(int add1, int add2, int result) {
        assertEquals(add1 + add2, result);
    }

    // 定义一个二维数组
    @DataProvider(name = "add")
    public Object[][] Users() {
        return new Object[][]{{3, 2, 5}, {2, 2, 4}, {3, 3, 7}};
    }

    @Test(dataProvider = "add")
    public void testAdd2(int add1, int add2, int result) {
        assertEquals(add1 + add2, result);
    }
}