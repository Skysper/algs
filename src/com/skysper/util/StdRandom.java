package com.skysper.util;

import java.util.Random;

/**
 * @author skysper
 * @author Robert Sedgewick
 * @author Kevin Wayne
 * @date 2018/10/27 0027 下午 22:48
 **/
public final class StdRandom {
    private static Random random;
    private static  long seed;
    static  {
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    /**
     * 禁用类初始化
     */
    private StdRandom() { }

    /**
     *
     * @param s
     */
    public static void setSeed(long s) {
        seed = s;
        random = new Random(seed);
    }

    public static long getSeed() {
        return seed;
    }

    /**
     * 返回随机实数[0,1)
     * @return
     */
    public static double uniform() {
        return random.nextDouble();
    }

    /**
     * 返回随机整数 [0,n)
     * @param n 一个正整数
     * @return 返回一个在0（包含）和{@code n} 间的整数
     * @throws IllegalArgumentException 如果 {@code n <= 0}
     */
    public static int uniform(int n) {
        if(n <= 0) {
            throw new IllegalArgumentException("argument must be positive: " + n);
        }
        return random.nextInt(n);
    }

    public static long uniform(long n) {
        if(n <= 0L) {
            throw new IllegalArgumentException("argument must be positive: " + n);
        }

        long r = random.nextLong();
        long m = n -1;
        if((n & m) == 0L) {
            return r & m;
        }

        // reject over-represented candidates
        long u = r >>> 1;
        while (u + m - (r = u % n) < 0L) {
            u = random.nextLong() >>> 1;
        }
        return r;
    }




}
