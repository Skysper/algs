package com.skysper.leetcode;

/**
 * 现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author skysper
 * @date 2022-03-24 23:28
 */
public class PowerN_50 {
    public double myPow(double x, int n) {
        if(x == 0) {
            return 0;
        }

        if(n == Integer.MIN_VALUE) {
            return (x == 1D || x == -1D) ? 1D : 0;
        }

        int pow = Math.abs(n);

        double t = x;
        double ans = 1d;
        while(pow > 0) {
            if((pow & 1) == 1) {
                ans  = ans * t;
            }

            pow = pow >> 1;

            t = t * t;
        }

        return  n < 0 ? 1D / ans : ans;

    }
}
