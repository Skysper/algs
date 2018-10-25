package com.skysper.test;

import com.skysper.algs.Math;

public class MathTest {

    public static void main(String[] args) {
        // write your code here
        int number = 214;
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
}
