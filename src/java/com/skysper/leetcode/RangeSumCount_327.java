package com.skysper.leetcode;

/**
 * 给你一个整数数组 nums 以及两个整数 lower 和 upper 。求数组中，值位于范围 [lower, upper] （包含 lower 和 upper）之内的 区间和的个数 。
 * <p>
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 * <p>
 *  
 * <p>
 * 示例 1：
 * 输入：nums = [-2,5,-1], lower = -2, upper = 2
 * 输出：3
 * 解释：存在三个区间：[0,0]、[2,2] 和 [0,2] ，对应的区间和分别是：-2 、-1 、2 。
 * 示例 2：
 * <p>
 * 输入：nums = [0], lower = 0, upper = 0
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-range-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author skysper
 * @date 2022-03-03 07:35
 */
public class RangeSumCount_327 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long[] pres = new long[nums.length];
        pres[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            pres[i] = pres[i - 1] + nums[i];
        }
        return process(pres, 0, pres.length - 1, lower, upper);
    }

    private int process(long[] arr, int left, int right, int lower, int upper) {
        if (left == right) {
            return (arr[left] >= lower && arr[left] <= upper) ? 1 : 0;
        }

        int mid = left + ((right - left) >> 1);

        return process(arr, left, mid, lower, upper) + process(arr, mid + 1, right, lower, upper)
                + merge(arr, left, mid, right, lower, upper);
    }


    private int merge(long[] arr, int left, int mid, int right, int lower, int upper) {

        long[] help = new long[right - left + 1];

        int ans = 0;
        int windowL = left;
        int windowR = left;
        for (int i = mid + 1; i <= right; i++) {
            long min = arr[i] - upper;
            long max = arr[i] - lower;

            while (windowR <= mid && arr[windowR] <= max) {
                windowR++;
            }
            while (windowL <= mid && arr[windowL] < min) {
                windowL++;
            }
            ans += windowR - windowL;
        }

        int a = left;
        int b = mid + 1;
        int index = 0;
        while (a <= mid && b <= right) {
            help[index++] = (arr[a] < arr[b]) ? arr[a++] : arr[b++];
        }

        while (a <= mid) {
            help[index++] = arr[a++];
        }

        while (b <= right) {
            help[index++] = arr[b++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }

        return ans;
    }

}
