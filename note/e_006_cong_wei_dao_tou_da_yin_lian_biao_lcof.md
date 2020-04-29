```
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

示例 1：

输入：head = [1,3,2]
输出：[2,3,1]
```

使用堆栈（双端队列等）
也可以使用ArrayList进行处理，后续进行逆序操作（使用ArrayList等减少空间操作）
```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // public int[] reversePrint(ListNode head) {
    //     Deque<Integer> list = new LinkedList<>();
    //     while(head != null) {
    //         list.add(head.val);
    //         head=head.next;
    //     }
    //     int[] result = new int[list.size()];
    //     for(int i=0;i<result.length; i++) {
    //         result[i] = list.removeLast();
    //     }
    //     return result;
    // }

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head=head.next;
        }

        int[] result = new int[list.size()];
        for(int i=0;i<result.length; i++) {
            result[i] = list.get(result.length - 1 -i);
        }
        return result;
    }
}
```
