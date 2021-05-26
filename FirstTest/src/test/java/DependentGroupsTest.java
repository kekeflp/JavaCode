import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * 依赖设置无需xml配置文件,仅注解即可
 * <p>
 * dependsOnGroups 来设置组的依赖，testAdd1()和 testAdd2() 同属于于 funtest组，testAdd3() 依赖于funtest组，
 * 该组有中有一条用例运行失败，则testAdd3() 不再执行。
 * <p>
 * 3依赖于1和2,只要1和2中有一个失败,3就不执行
 *
 * @author Liping Fu
 */
public class DependentGroupsTest {

    @Test(groups = {"funtest"})
    public void testAdd1() {
        assertEquals(3 + 1, 5);
    }

    @Test(groups = {"funtest"})
    public void testAdd2() {
        assertEquals(3 + 2, 5);
    }

    @Test(dependsOnGroups = {"funtest"})
    public void testAdd3() {
        assertEquals(3 + 2, 5);
    }
}