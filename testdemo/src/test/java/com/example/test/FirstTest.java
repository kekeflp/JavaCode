package com.example.test;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class FirstTest {
    @Test
    public void testCase() {
        assertEquals(2 + 2, 4);
    }
}
