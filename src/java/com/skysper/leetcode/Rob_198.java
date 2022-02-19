package com.skysper.leetcode;

/**
 * @author skysper
 * @date 2022-02-19 22:21
 */
public class Rob_198 {
    /**
     * 经典动态规划
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        //后面的选项依赖前面的选择
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
