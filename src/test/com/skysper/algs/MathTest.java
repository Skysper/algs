package com.skysper.algs;

import com.skysper.ConstPool;

/**
 * @author skysper
 */
public class MathTest {

    public static void main(String[] args) {
        int number = 214;
        MathTest.testSqrt(number);

        MathTest.testGcd(65, 39);
    }

    private static void testSqrt(int number) {
        double result = Math.sqrt(number);
        System.out.println("result is :" + result);
        result = java.lang.Math.sqrt(number);
        System.out.println("java.lang.Math result is :" + result);

        long begin = System.currentTimeMillis();
        for(int i = 0; i < ConstPool.TEN_MILLION; i++) {
            Math.sqrt(number + i/100);
        }
        System.out.println("use com.skysper.algs.Math, total times:" + (System.currentTimeMillis() - begin));
        begin = System.currentTimeMillis();
        for(int i = 0; i < ConstPool.TEN_MILLION; i++) {
            java.lang.Math.sqrt(number + i/100);
        }
        System.out.println("use java.lang.Math,total times:" + (System.currentTimeMillis() - begin));
    }

    private static void testGcd(int a, int b) {
        int result = Math.gcd(a, b);
        System.out.println("max gcd is " + result);
    }

}
