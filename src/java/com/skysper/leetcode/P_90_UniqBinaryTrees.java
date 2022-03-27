package com.skysper.leetcode;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：5
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author skysper
 * @date 2022-03-27 22:38
 */
public class P_90_UniqBinaryTrees {
    //卡特兰数


    // 假设 n 个节点存在二叉排序树的个数是 G (n)，令 f(i) 为以 i 为根的二叉搜索树的个数，则
    // G(n) = f(1) + f(2) + f(3) + f(4) + ... + f(n)

    // 当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i，则
    // f(i) = G(i-1)*G(n-i)

    // 综合两个公式可以得到 卡特兰数 公式
    // G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            //j代表左边的节点个数  i - 1 - j代表右边的节点个数
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}
