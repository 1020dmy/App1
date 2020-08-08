package com.example.liangxq.shopping;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void test(){
        Demo2 demo = new Demo2();
        demo.print(1);
        demo.print("asdasd");
        demo.print1(new Demo2().new Demo3());
    }
}