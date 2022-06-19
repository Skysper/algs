package com.skysper.leetcode;

/**
 * @author skysper
 * @date 2022-06-19 23:11
 */
public class P_11_Water {

    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     *
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 返回容器可以储存的最大水量。
     *
     * 说明：你不能倾斜容器。
     *
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     * 水平距离越长，可能性越大，
     * 双指针滑动，那边小那边往中间滑动，以确定一个继续推高蓄水量
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int ans = 0;

        while(left < right) {
            int cap = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, cap);

            if(height[left]  < height[right]) {
                left ++;
            } else {
                right--;
            }
        }

        return ans;

    }
}
