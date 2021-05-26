import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 *
 * 依赖设置无需xml配置文件,仅注解即可
 *
 * dependsOnMethods 来设置用例的依赖，当 testAdd1() 运行失败时，则 testAdd2() 不再被执行
 * 相当于2依赖于1, 1不成功,则到不了2,
 * 和优先级的区别在于:
 * 存在依赖的话, 前一个存在失败后面就不执行(停止);
 * 优先级是都能被执行,只是一个先后关系;
 *
 * @author Liping Fu
 *
 */
public class DependentMethodsTest {

    @Test
    public void testAdd1() {
        assertEquals(3 + 1, 5);
    }

    @Test(dependsOnMethods = {"testAdd1"})
    public void testAdd2() {
        assertEquals(3 + 2, 5);
    }

}
