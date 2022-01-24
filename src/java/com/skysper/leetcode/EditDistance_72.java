package com.skysper.leetcode;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author skysper
 * @date 2022-01-24 23:27
 */
public class EditDistance_72 {

    public int minDistance(String word1, String word2) {
        int L1 = word1.length() + 1;
        int L2 = word2.length() + 1;
        int[][] dp = new int[L1][L2];

        //如果各个代价不同，可以进行更加复杂的筛选
        //增加
        int ic = 1;
        //删除
        int dc = 1;
        //复制
        int cc = 0;
        //替换
        int rc = 1;

        for(int i =1; i < L1; i++) {
            dp[i][0] = i * dc;
        }
        for(int i = 1; i < L2; i++) {
            dp[0][i] = i * ic;
        }

        for(int i = 1; i < L1; i++) {
            for(int j = 1; j < L2; j++) {
                //增加新的字符
                dp[i][j] = dp[i][j-1] + 1*ic;
                //末尾一致，直接copy
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + 1 * cc);
                } else {
                    //末尾不一致，进行替换
                    dp[i][j] = Math.min(dp[i-1][j-1] + 1 * rc, dp[i][j]);
                }

                //直接删除末尾字符
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + 1*dc);
                //删除末尾字符，增加另外的字符
                dp[i][j] = Math.min(dp[i-1][j-1] + 1* dc + 1 * ic, dp[i][j]);
            }
        }

        return dp[L1-1][L2-1];

    }
}
