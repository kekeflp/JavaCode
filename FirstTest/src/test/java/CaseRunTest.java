import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * 按顺序执行
 *
 * @author Liping Fu
 *
 */
public class CaseRunTest {

    @Test
    public void testCase1() {
        assertEquals(2 + 2, 4);
    }

    @Test
    public void testCase2() {
        assertEquals(2 + 2, 4);
    }

    @Test
    public void testCase3() {
        assertEquals(2 + 2, 4);
    }
}
