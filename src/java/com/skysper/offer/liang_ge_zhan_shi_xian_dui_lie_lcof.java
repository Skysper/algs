package com.skysper.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author skysper
 * @date 2022-01-17 23:43
 */
public class liang_ge_zhan_shi_xian_dui_lie_lcof {
    static class CQueue {
        Deque<Integer> first = new LinkedList<>();
        Deque<Integer> second = new LinkedList<>();
        public CQueue() {
            //
        }

        public void appendTail(int value) {
            first.push(value);
        }

        public int deleteHead() {
            if(!second.isEmpty()) {
                return second.pop();
            }
            while(!first.isEmpty()) {
                second.push(first.pop());
            }
            if(second.isEmpty()) {
                return -1;
            }

            return second.pop();
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
}
