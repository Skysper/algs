package com.skysper.leetcode;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 只可能是）点位，同时判断前一个位置最长的延长位置，以及最长位置之前的（括号匹配后的更加长的位置
 * @author skysper
 * @date 2022-06-19 23:28
 */
public class P_32_LVP {

    public int longestValidParentheses(String s) {
        char[] array = s.toCharArray();
        int n = array.length;

        int[] dp = new int[n + 1];

        int pre = -1;
        int ans = 0;
        for(int i = 1; i < n; i++) {
            if(array[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if(pre >= 0 && array[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
