package com.skysper.leetcode;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author skysper
 * @date 2022-06-19 23:30
 */
public class P_33_SIRA {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {

            int mid = (left + right) / 2;
            //相等，直接返回
            if(nums[mid] == target) {
                return mid;
            }
            // 左中右均相等
            // 从左向右不断判断，
            if(nums[mid] == nums[left] && nums[mid] == nums[right]) {
                while(nums[mid] == nums[left] && left != mid) {
                    left++;
                }

                // L和M没撞上，[L]!=[M] L,.....M
                if (left == mid) {
                    left = mid + 1;
                    continue;
                }
            }

            //左边！=中间
            if(nums[left] != nums[mid]) {
                //中间的>左边
                if(nums[mid] > nums[left]) {
                    //目标位于左半边
                    if(target >= nums[left] && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        //目标位于有半天
                        left = mid + 1;
                    }
                } else {
                    //中间的小于左边
                    //目标位于右半天（递增部分）
                    if(target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            } else { //nums[mid] != nums[right]
                if(nums[mid] > nums[right]) {
                    if(nums[left] <= target && nums[mid] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if(nums[mid] < target && nums[right] >= target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}
