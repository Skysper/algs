package com.skysper.leetcode;

/**
 * @author skysper
 * @date 2022-02-19 22:19
 */
public class NumberSplit_7 {
    /**
     * 按照负数处理，可以获得更大的数据空间
     * @param x
     * @return
     */
    public int reverse(int x) {
        boolean neg = x < 0;
        x = neg ? x : -x;
        int res = 0;
        while (x != 0) {
            int m = x % 10;
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE/ 10 &&  m < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            res = res * 10 + m;
            x = x / 10;
        }

        if(res == Integer.MIN_VALUE && !neg) {
            return 0;
        }

        return neg ? res : -res;

    }
}
