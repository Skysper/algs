package com.skysper.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调栈结构
 * @author skysper
 * @date 2022-05-09 09:04
 */
public class P_739_Temperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Deque<Integer> queue = new LinkedList<>();

        //大到小
        for(int i = 0; i < temperatures.length; i++) {

            while(!queue.isEmpty() && temperatures[queue.peekLast()] < temperatures[i]) {
                result[queue.peekLast()] = i - queue.peekLast();
                queue.pollLast();
            }
            queue.addLast(i);
        }

        while(!queue.isEmpty()) {
            result[queue.poll()] = 0;
        }
        return result;
    }
}
