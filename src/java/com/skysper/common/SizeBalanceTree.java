package com.skysper.common;

/**
 * @author skysper
 * @date 2022-03-15 09:45
 */
public class SizeBalanceTree<K extends Comparable<K>, V> {

    public static class SBTNode<K extends Comparable<K>, V> {
        public K key;
        public V value;
        public SBTNode<K, V> left;
        public SBTNode<K, V> right;
        //不同key的数量
        public int size;

        public SBTNode(K key, V val) {
            this.key = key;
            this.value = val;
            this.size = 1;
        }
    }


    private SBTNode<K, V> root;

    private SBTNode<K,V> rightRotate(SBTNode<K, V> node) {
        SBTNode<K, V> leftNode = node.left;

        node.left = leftNode.right;
        leftNode.right = node;

        leftNode.size = node.size;

        node.size = (node.left != null ? node.left.size : 0)
                + (node.right != null ? node.right.size : 0) + 1;

        return leftNode;
    }

    private SBTNode<K, V> leftRotate(SBTNode<K, V> node) {
        SBTNode<K, V> rightNode = node.right;

        node.right = rightNode.left;
        rightNode.left = node;

        rightNode.size = node.size;

        node.size = (node.left != null ? node.left.size : 0)
                + (node.right != null ? node.right.size : 0) + 1;

        return rightNode;
    }

    private SBTNode<K, V> maintain(SBTNode<K, V> cur) {
        if(cur == null) {
            return null;
        }

        int leftSize = cur.left != null ? cur.left.size : 0;
        int leftLeftSize = cur.left!= null && cur.left.left != null ? cur.left.left.size : 0;
        int leftRightSize = cur.left != null && cur.left.right != null ? cur.left.right.size : 0;

        int rightSize = cur.right != null ? cur.right.size : 0;
        int rightLeftSize = cur.right!= null && cur.right.left != null ? cur.right.left.size : 0;
        int rightRightSize = cur.right != null && cur.right.right != null ? cur.right.right.size : 0;

        //LL
        if(leftLeftSize > rightSize) {
            cur = rightRotate(cur);
            //调整right和头部
            cur.right = maintain(cur.right);
            cur = maintain(cur);
        } else if(leftRightSize > rightLeftSize) {
            cur.left = leftRotate(cur.left);
            cur = rightRotate(cur);
            cur.left = maintain(cur.left);
            cur.right = maintain(cur.right);
            cur =maintain(cur);
        } else if(rightRightSize > leftSize) {
            cur = leftRotate(cur);
            cur.left = maintain(cur.left);
            cur = maintain(cur);
        } else if(rightLeftSize > leftSize) {
            cur.right = rightRotate(cur.right);
            cur  = leftRotate(cur);

            cur.left = maintain(cur.left);
            cur.right = maintain(cur.right);
            cur =maintain(cur);
        }

        return cur;
    }



    public static void main(String[] args) {

    }
}
