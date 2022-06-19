package com.skysper.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 *
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author skysper
 * @date 2022-06-19 23:36
 */
public class P_39_combination_sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> items = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        process(candidates, 0, target, current, items);

        return items;
    }

    public void process(int[] candidates, int begin, int target, List<Integer> current, List<List<Integer>> result) {
        if(begin == candidates.length) {
            return;
        } else if(target == 0) {
            result.add(new ArrayList<>(current));
        } else if(target < 0) {
            return;
        } else {

            for(int i = begin; i < candidates.length; i++) {
                current.add(candidates[i]);
                //把i位置的全部穷尽，然后切换下一个起始位置
                process(candidates, i, target - candidates[i], current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
