package com.skysper.algs;

import com.skysper.ConstPool;
import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

/**
 * @author skysper
 */
@RunWith(JUnit4ClassRunner.class)
public class MathTest {

    @Test
    public void testSqrt() {
        int number = 214;
        double jdkResult = Math.sqrt(number);
        System.out.println("result is :" + jdkResult);
        double mineResult = java.lang.Math.sqrt(number);
        System.out.println("java.lang.Math result is :" + mineResult);

        Assert.assertEquals(jdkResult, mineResult, 0.0000000001);
    }

    @Test
    public void testGcd() {
        int a =65,b=39;
        int result = Math.gcd(a, b);
        Assert.assertEquals(13, result);
    }

    @Test
    public void runPerformance(){
        int number = 214;
        long begin = System.currentTimeMillis();
        for(int i = 0; i < ConstPool.TEN_MILLION; i++) {
            Math.sqrt(number + i/100);
        }
        System.out.println("use com.skysper.algs.Math, total times:" + (System.currentTimeMillis() - begin) +"ms");
        begin = System.currentTimeMillis();
        for(int i = 0; i < ConstPool.TEN_MILLION; i++) {
            java.lang.Math.sqrt(number + i/100);
        }
        System.out.println("use java.lang.Math,total times:" + (System.currentTimeMillis() - begin) + "ms");
    }

}
