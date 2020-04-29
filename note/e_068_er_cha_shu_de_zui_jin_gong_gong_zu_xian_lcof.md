```
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]


示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。

-----3------
--5--- -1---
-6--2- 0--8-
---7-4
```

NOTE: 所有节点值唯一，否则不好判定
其次，p、q为不同节点，且均存在于给定的二叉树中，所以最终必定返回确定的值，最大是根节点，而不会是null

```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p, q);
    }

    private TreeNode find(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null || node == p || node == q) {
            return node;
        }

        TreeNode left = find(node.left, p, q);
        TreeNode right = find(node.right, p, q);

        if(left == null) return right;
        if(right == null) return left;
        return node;
    }
}
```

如果说p或q有一个不存在于节点中，则需要判定在遍历中碰到过p、q，如果任意一个未碰到，则返回null   
增加记忆节点findNode
```
class Solution {
    TreeNode findNode = new TreeNode(0);
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = find(root, p, q);
        if(findNode.left == null || findNode.right == null) {
            return null;
        }
        return node;
    }

    private TreeNode find(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) {
            return node;
        }
        if(node == p) {
            findNode.left = node;
            return node;
        }  else if(node == q) {
            findNode.right = node;
            return node;
        }

        TreeNode left = find(node.left, p, q);
        TreeNode right = find(node.right, p, q);

        if(left == null) return right;
        if(right == null) return left;
        return node;
    }
}
```




