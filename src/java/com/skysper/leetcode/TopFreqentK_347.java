package com.skysper.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author skysper
 * @date 2022-03-16 21:43
 */
public class TopFreqentK_347 {

    public static class Node {
        private int num;
        private int count;

        public Node(int num) {
            this.num = num;
            this.count = 0;
        }
    }

    public static class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.num - o2.num;
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Node> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Node node = map.getOrDefault(nums[i], new Node(nums[i]));
            node.count++;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());

        for (Node value : map.values()) {
            if (queue.peek() == null || queue.peek().count < value.count) {
                queue.add(value);
            }

            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] ans = new int[queue.size()];

        int index = 0;
        while (!queue.isEmpty()) {
            ans[index++] = queue.poll().num;
        }
        return ans;
    }

}
