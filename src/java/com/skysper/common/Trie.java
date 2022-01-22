package com.skysper.common;

/**
 * #公共的数据结构#
 * 前缀树
 * @author skysper
 * @date 2022-01-22 23:18
 */
public class Trie {

    private boolean ends;

    private Trie[] tries;

    public Trie() {
        ends = false;
        tries = new Trie[26];
    }

    public void insert(String word) {
        char[] array = word.toCharArray();

        int length = array.length;
        int i = 0;
        Trie node = this;
        while(i < length) {
            char c = array[i];
            if(node.tries[c - 'a'] == null) {
                Trie newNode = new Trie();
                node.tries[c-'a'] = newNode;
                if( i == length - 1) {
                    newNode.ends = true;
                }
                node = newNode;
            } else {
                node = node.tries[c - 'a'];
                if( i == length - 1) {
                    node.ends = true;
                }
            }
            i++;
        }
    }

    public boolean search(String word) {
        char[] array = word.toCharArray();
        Trie node = this;

        int i = 0;
        while( i < array.length) {
            char c = array[i];
            if(node.tries[c - 'a'] == null) {
                return false;
            } else {
                node = node.tries[c - 'a'];
            }
            i++;
        }

        return node!= null && node.ends;
    }

    public boolean startsWith(String prefix) {
        char[] array = prefix.toCharArray();

        Trie node =this;

        int i = 0;
        while(i < array.length) {
            char c = array[i];
            if(node.tries[c - 'a'] == null) {
                return false;
            }
            node = node.tries[c - 'a'];
            i++;
        }
        return node != null;
    }

}