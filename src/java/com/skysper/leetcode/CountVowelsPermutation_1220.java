package com.skysper.leetcode;

/**
 * 给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：
 *
 * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
 * 每个元音 'a' 后面都只能跟着 'e'
 * 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
 * 每个元音 'i' 后面 不能 再跟着另一个 'i'
 * 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
 * 每个元音 'u' 后面只能跟着 'a'
 * 由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-vowels-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author skysper
 * @date 2022-01-17 23:27
 */
public class CountVowelsPermutation_1220 {

    /**
     * 使用递归的方式难以计算出最终答案
     * 肯定超时
     * @param n
     * @return
     */
    public int countVowelPermutation2(int n) {

        long total = calc('a', n) + calc('e', n) + calc('i', n) + calc('o', n) + calc('u', n);

        return (int)(total % (1_000_000_000 + 7));
    }

    private int calc(char c, int n) {
        if(n == 1) {
            return 1;
        }
        if(c == 'a') {
            return calc('e', n-1);
        } else if(c == 'e') {
            return calc('a', n-1) + calc('i', n-1);
        } else if(c == 'i') {
            return calc('a', n-1) + calc('e', n-1) + calc('o', n-1) + calc('u', n-1);
        } else if(c == 'o') {
            return calc('i', n-1) + calc('u', n-1);
        } else {
            return calc('a', n - 1);
        }
    }

    /**
     * 使用动态规划
     * 递归的方式存在很多的重复计算
     * @param n
     * @return
     */
    public int countVowelPermutation(int n) {
        long[][] dp = new long[5][n+1];
        for(int i = 0; i < 5; i++) {
            dp[i][1] = 1;
        }

        long item = 1_000_000_000 + 7L;
        for(int i =2; i <= n; i++) {
            //每次计算后，都要对所有数据进行取模操作
            dp[0][i] = dp[1][i-1] % item;
            dp[1][i] = (dp[0][i-1] + dp[2][i-1])% item;
            dp[2][i] = (dp[0][i-1]  + dp[1][i-1]  + dp[3][i-1]  + dp[4][i-1])% item;
            dp[3][i] = (dp[2][i-1] + dp[4][i-1])% item;
            dp[4][i] = (dp[0][i-1])% item;
        }

        long total = 0;
        for(int i = 0; i < 5; i++) {
            total += dp[i][n];
        }
        //最终答案再次取模
        return (int)(total % item);
    }

}
