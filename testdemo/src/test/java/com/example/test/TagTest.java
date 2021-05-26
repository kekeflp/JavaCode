package com.example.test;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/*
* 分组测试
*
* */
@Test(groups = "功能测试")
public class TagTest {

    @Test(groups = { "高", "正常" })
    public void testCase1() {
        assertEquals(2 + 2, 4);
    }

    @Test(groups = { "高", "正常" })
    public void testCase2() {
        assertEquals(5 - 3, 2);
    }

    @Test(groups = { "中", "正常" })
    public void testCase3() {
        assertEquals(2 / 1, 2);
    }

    @Test(groups = { "低", "异常" })
    public void testCase4() {
        assertEquals(2 / 0, 1);
    }
}
