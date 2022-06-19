package com.skysper.leetcode;

/**
 *
 * 确认能够不断刷新maxR最大值的情况
 * @author skysper
 * @date 2022-06-19 23:47
 */
public class P_55_can_jump {
    /**
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if(nums.length == 1) {
            return true;
        }

        int maxR = nums[0];
        int i = 0;
        while(i < nums.length) {
            if(i > maxR) {
                return false;
            }
            maxR = Math.max(maxR, i + nums[i]);
            i++;
        }
        return true;
    }
}
