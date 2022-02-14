package com.skysper.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个整数数组，它表示BST(即 二叉搜索树 )的 先序遍历 ，构造树并返回其根。
 *
 * 保证 对于给定的测试用例，总是有可能找到具有给定需求的二叉搜索树。
 *
 * 二叉搜索树 是一棵二叉树，其中每个节点， Node.left 的任何后代的值 严格小于 Node.val , Node.right 的任何后代的值 严格大于 Node.val。
 *
 * 二叉树的 前序遍历 首先显示节点的值，然后遍历Node.left，最后遍历Node.right。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author skysper
 * @date 2022-02-14 22:29
 */
public class BSTFromPreOrder_1008 {
     //Definition for a binary tree node.
     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) {
            return null;
        }

        Deque<Integer> deque = new LinkedList<>();

        int[] bigArray = new int[preorder.length];
        for(int i =0; i< bigArray.length;i++) {
            bigArray[i] = -1;
        }

        for (int i = 0; i < preorder.length; i++) {
            if(deque.isEmpty()) {
                deque.add(i);
            } else if(preorder[i] > preorder[deque.peek()]) {
                while(!deque.isEmpty() && preorder[i] > preorder[deque.peek()]) {
                    bigArray[deque.peek()] = i;
                    deque.pop();
                }
                deque.push(i);
            } else {
                deque.push(i);
            }
        }
        for(int i=0; i < bigArray.length; i++) {
            System.out.println("c:"+bigArray[i]);
        }



        return process(preorder, 0, preorder.length - 1, bigArray);
    }

    //最优解，单调栈
    public TreeNode process(int[] preorder, int start, int end, int[] bigArray) {
        if(start > end) {
            return null;
        }
        int firstBig = bigArray[start];
        firstBig = (firstBig == -1) ? end + 1 : firstBig;
        TreeNode node = new TreeNode(preorder[start]);
        node.left = process(preorder, start + 1, firstBig - 1, bigArray);
        node.right = process(preorder, firstBig, end, bigArray);

        return node;
    }

//    //二叉树递归套路
//    private TreeNode process(int[] preorder, int start, int end) {
//        if(start > end) {
//            return null;
//        }
//
//        int firstBig = start + 1;
//        for(; firstBig <= end; firstBig++) {
//            if(preorder[firstBig] > preorder[start]) {
//                break;
//            }
//        }
//
//        TreeNode head = new TreeNode(preorder[start]);
//
//        head.left = process(preorder, start+1, firstBig - 1);
//        head.right = process(preorder, firstBig, end);
//        return head;
//    }



}
