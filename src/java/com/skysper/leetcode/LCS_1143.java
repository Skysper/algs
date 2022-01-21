package com.skysper.leetcode;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * 示例 1：
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author skysper
 * @date 2022-01-18 23:06
 */
public class LCS_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();

        int len1 = str1.length;
        int len2 = str2.length;

        //初始化（0,0）位置
        int[][] dp = new int[len1][len2];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;

        //初始化0列
        //任何一个位置为1后，剩下的数据至少至多为1
        for(int i = 1; i < len1; i++) {
            dp[i][0] = str1[i] == str2[0] ? 1 : dp[i-1][0];
        }
        //初始化0行
        //任何一个位置为1后，剩下的数据至少至多为1
        for(int i = 1; i < len2; i++) {
            dp[0][i] = str1[0] == str2[i] ? 1 : dp[0][i-1];
        }


        for(int i =1; i < len1; i++) {
            for(int j = 1; j < len2; j++) {
                //分情况讨论
                //即双方结尾字符相同、一方结尾字符在最长公共序列中、双方结尾字符均不在等情况
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if(str1[i] == str2[j]) {
                    dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i][j]);
                }
            }
        }

        return dp[len1-1][len2-1];
    }
}
