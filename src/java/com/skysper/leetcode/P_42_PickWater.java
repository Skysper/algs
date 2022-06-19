package com.skysper.leetcode;

/**
 *给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author skysper
 * @date 2022-02-21 00:02
 */
public class P_42_PickWater {

    public int trap(int[] height) {
        if(height.length <= 2) {
            return 0;
        }
        //左侧最大值
        int maxL = height[0];
        //右侧最大值
        int maxR = height[height.length - 1];

        //两侧最大值为里面可接雨水的边界，
        //即查找到后面第一个比边界大的数据中间皆可以接到雨水

        //初始化了maxL和maxR，查询可以从1和height.length - 2开始
        int left = 1;
        int right = height.length - 2;
        int sum = 0;

        while(left <= right) {
            if(maxL < maxR) {
                int h = maxL - height[left];
                sum +=  h > 0 ?  h : 0;
                maxL = Math.max(height[left], maxL);
                left++;
            } else {
                int h = maxR - height[right];
                sum+= h > 0 ? h : 0;

                maxR = Math.max(height[right], maxR);
                right--;
            }
        }

        return sum;
    }


    public int trap2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        left++;
        right--;
        int sum = 0;
        while(left <= right) {
            if(leftMax < rightMax) {
                sum += Math.max(leftMax - height[left], 0);
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                sum += Math.max(rightMax - height[right], 0);
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }

        return sum;

    }


}
