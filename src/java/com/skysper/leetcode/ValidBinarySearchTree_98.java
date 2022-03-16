package com.skysper.leetcode;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [2,1,3]
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author skysper
 * @date 2022-03-17 00:48
 */
public class ValidBinarySearchTree_98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class Node {
        Integer max;
        Integer min;
        boolean valid;

        public Node(Integer min, Integer max, boolean valid) {
            this.min = min;
            this.max = max;
            this.valid = valid;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return process(root).valid;

    }

    private Node process(TreeNode node) {
        if (node.left == null && node.right == null) {
            return new Node(node.val, node.val, true);
        }
        int min = 0;
        int max = 0;
        Node left = null;
        if (node.left != null) {
            left = process(node.left);
            min = left.min;
        } else {
            min = node.val;
        }

        Node right = null;

        if (node.right != null) {
            right = process(node.right);
            max = right.max;
        } else {
            max = node.val;
        }

        boolean valid = (left == null || node.val > left.max) && (right == null || node.val < right.min);

        if (left != null && !left.valid) {
            valid = false;
        }
        if (right != null && !right.valid) {
            valid = false;
        }

        return new Node(min, max, valid);
    }
}
