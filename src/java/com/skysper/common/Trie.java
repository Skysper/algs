package com.skysper.common;

/**
 * #公共的数据结构#
 * 前缀树
 * @author skysper
 * @date 2022-01-22 23:18
 */
public class Trie {

    public static class Node {
        boolean end;
        Node[] nexts;
        public Node() {
            this.end = false;
            this.nexts = new Node[26];
        }
    }

    Node head;
    public Trie() {
        head = new Node();
    }

    public void insert(String word) {
        char[] array =word.toCharArray();
        Node cur = head;
        for(int i = 0; i < array.length; i ++) {
            int index = array[i] - 'a';
            Node node = cur.nexts[index] != null ? cur.nexts[index] : new Node();
            cur.nexts[index] = node;
            cur = node;
        }
        cur.end = true;
    }

    public boolean search(String word) {
        char[] array = word.toCharArray();
        Node cur = head;
        for(int i = 0; i < array.length; i ++) {
            int index = array[i] - 'a';
            if(cur.nexts[index] == null) {
                return false;
            }
            cur = cur.nexts[index];
        }
        return cur.end;
    }

    public boolean startsWith(String prefix) {
        char[] array =prefix.toCharArray();
        Node cur = head;
        for(int i = 0; i < array.length; i ++) {
            int index = array[i] - 'a';
            if(cur.nexts[index] == null) {
                return false;
            }
            cur = cur.nexts[index];
        }
        return true;
    }
}
