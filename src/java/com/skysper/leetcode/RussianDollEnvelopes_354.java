package com.skysper.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 *
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 注意：不允许旋转信封。
 *
 *  
 * 示例 1：
 *
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author skysper
 * @date 2022-01-21 23:08
 *
 * @see LIS_300
 */
public class RussianDollEnvelopes_354 {

    public static class Node {
        int w;
        int h;
        public Node(int w, int h) {
            this.w = w;
            this.h = h;
        }

        @Override
        public String toString() {
            return this.w+":" + this.h;
        }
    }

    public static int maxEnvelopes(int[][] envelopes) {
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < envelopes.length; i++) {
            final int w = envelopes[i][0];
            final int h = envelopes[i][1];

            nodeList.add(new Node(w, h));
        }
        Collections.sort(nodeList, (a, b)->{
            if(a.w == b.w) {
                return Integer.compare(b.h, a.h);
            } else {
                return Integer.compare(a.w, b.w);
            }
        });
        //排序后，抽象为最长递减子序列的问题
        int length = nodeList.size();
        int[] dp = new int[length];
        int[] ends = new int[length];

        //dp的问题解决方式
        // 3、2、4、1、7、6、9
        // 1、1、2、1、3、3、4

        int right = 0;
        ends[0] = nodeList.get(0).h;
        dp[0] = 1;

        for(int i =0; i < nodeList.size(); i++) {
            Node node = nodeList.get(i);
            int h = node.h;

            int l = 0;
            int r = right;
            //二分查找大于等于h最左侧的值
            while(l <= r) {
                int mid = (l + r) / 2;
                if(ends[mid] >= h) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            right = Math.max(right, l);

            ends[l] = h;
            dp[i] = l + 1;
        }

        return right + 1;

    }

    public static void main(String[] args) {
        int[][] a = new int[4][2];
        a[0][0] = 3;
        a[0][1] = 4;

        a[1][1] = 2;
        a[1][0] = 5;

        a[2][1] = 1;
        a[2][0] = 3;

        System.out.println(maxEnvelopes(a));
    }

}
