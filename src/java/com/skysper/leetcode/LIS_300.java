package com.skysper.leetcode;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *  
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author skysper
 * @date 2022-01-21 22:54
 */
public class LIS_300 {

    /**
     * 算法复杂度 O(N*log(N))
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        int[] ends = new int[length];
        dp[0] = 1;
        ends[0] = nums[0];
        //right为最远能够扩展到的索引
        int right = 0;

        for(int i = 1; i < length; i++) {
            int n = nums[i];
            int l = 0;
            int r = right;
            //二分查找大于n最左侧的值
            while(l <= r) {
                int mid = (l + r) / 2;
                if(ends[mid] >= n) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            //确认是否更新right
            right = Math.max(right, l);

            ends[l] = n;
            dp[i] = l + 1;
        }

        return right + 1;
    }
}
