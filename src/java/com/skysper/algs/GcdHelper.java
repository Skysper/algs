package com.skysper.algs;

/**
 * @author skysper
 * @date 2022-05-05 11:17
 */
public class GcdHelper {

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int gcd2(int a, int b) {
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }
}
