package com.example.test;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * 其他小技巧
 *
 * @author Liping Fu
 */
public class TipsTest {
    // 该条用例跳过执行, 相当于禁用
    @Test(enabled = false)
    public void testCase1() {
        assertEquals(2 + 2, 4);
    }

    // 设定用例超时时间
    // 设置用例运行的超时间，3000 单位为毫秒，当用例运行时间超过 3000 毫秒则判定为失败。不管用例本身是否运行失败。
    @Test(timeOut = 3000)
    public void testCase2() throws InterruptedException {
        Thread.sleep(3001);
    }

    // 预设用例抛出的异常类型
    // 用来预设用例运行会出现的异常。例如 2⁄0 将会抛出 RuntimeException 类型的异常，如果出现异常则表示用例执行成功。
    @Test(expectedExceptions = RuntimeException.class)
    public void testCase3() {
        assertEquals(2 / 0, 1);
    }
}
