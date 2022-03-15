package com.skysper.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author skysper
 * @date 2022-03-15 09:46
 */
public class SkipListMap<K extends Comparable<K>, V> {

    private static class SkipListNode<K extends Comparable<K>, V> {
        K key;
        V value;
        List<SkipListNode<K, V>> nexts;

        SkipListNode(K k, V v) {
            this.key = k;
            this.value = v;
            this.nexts = new ArrayList<>();
        }

        public boolean isKeyLess(K otherKey) {
            return otherKey != null && (this.key == null || this.key.compareTo(otherKey) < 0);
        }

        public boolean isKeyEqual(K otherKey) {
            return (this.key ==null && otherKey == null) || (key != null && otherKey != null && key.compareTo(otherKey) == 0);
        }
    }

    private int maxLevel;
    private int size;
    private SkipListNode<K, V> head;

    private static final double PROBABILITY = 0.5d;

    public SkipListMap() {
        head = new SkipListNode<>(null, null);
        head.nexts.add(null);
        size = 0;
        maxLevel = 0;
    }


    private SkipListNode<K,V> getMostRightLessInLevel(SkipListNode<K,V> cur, int level, K k) {
        if(cur == null) {
            return null;
        }

        while(cur.nexts.get(level) != null && cur.nexts.get(level).isKeyLess(k)) {
            cur = cur.nexts.get(level);
        }

        return cur;
    }

    private boolean newLevel() {
        return Math.random() < PROBABILITY;
    }

    private SkipListNode<K,V> mostRightLessNodeInTree(K key) {
        if(key == null) {
            return null;
        }
        int level = maxLevel;
        SkipListNode<K, V> cur = head;
        while(level >= 0) {
            cur = getMostRightLessInLevel(cur, level--, key);
        }
        return cur;
    }

    public void put(K key, V value) {
        if(key == null) {
            return;
        }

        SkipListNode<K,V> less = mostRightLessNodeInTree(key);
        SkipListNode<K, V> find = less.nexts.get(0);
        if(find != null && find.isKeyEqual(key)) {
            find.value = value;
        } else {
            size++;

            int myLevel = 0;
            SkipListNode<K,V> cur = new SkipListNode<>(key, value);
            cur.nexts.add(null);
            while (newLevel()) {
                myLevel++;
                cur.nexts.add(null);
            }

            while(myLevel > maxLevel) {
                this.head.nexts.add(null);
                maxLevel++;

            }

            SkipListNode<K, V> pre = head;
            int level = maxLevel;

            while(level >= 0) {
                pre = getMostRightLessInLevel(pre, level, key);

                if(level <= myLevel) {
                    SkipListNode<K, V> next = pre.nexts.get(level);
                    pre.nexts.set(level, cur);
                    cur.nexts.set(level, next);
                }
                level--;
            }
        }
    }

    public boolean containsKey(K key) {
        int level = this.maxLevel;
        SkipListNode<K, V> node = mostRightLessNodeInTree(key);
        if(node == null) {
            return false;
        }
        SkipListNode<K,V> find = node.nexts.get(0);
        return find != null && find.isKeyEqual(key);
    }


    private void remove(K key) {

        if(containsKey(key)) {
            size--;

            int level = maxLevel;

            SkipListNode<K,V> pre = head;
            while(level >= 0) {
                pre = getMostRightLessInLevel(head, level, key);

                SkipListNode<K, V> next = pre.nexts.get(level);

                if(next != null && next.isKeyEqual(key)) {
                    pre.nexts.set(level, next.nexts.get(level));
                }
                if(level != 0 && pre == head && pre.nexts.get(level) == null) {
                    pre.nexts.remove(level);
                    maxLevel--;
                }
                level--;
            }
        }
    }

    public K firstKey() {
        return this.head.nexts.get(0) != null ? this.head.nexts.get(0).key : null;
    }

    public K lastKey() {
        SkipListNode<K, V> node = head;
        int level = maxLevel;
        while(level >= 0) {

            SkipListNode<K, V> next = node.nexts.get(level);
            while(next != null) {
                node = next;
                next = node.nexts.get(level);
            }
            level--;
        }
        return node.key;
    }

    public K floorKey(K key) {
        final SkipListNode<K, V> cur = mostRightLessNodeInTree(key);
        SkipListNode<K,V> next = cur.nexts.get(0);
        if(next != null && next.isKeyEqual(key)) {
            return key;
        } else {
            return cur.key;
        }
    }

    public K ceilingKey(K key) {
        final SkipListNode<K, V> cur = mostRightLessNodeInTree(key);
        SkipListNode<K,V> next = cur.nexts.get(0);
        if(next != null && next.isKeyEqual(key)) {
            return key;
        } else {
            return next == null ? null : next.key;
        }
    }

    public static void printAll(SkipListMap<String, String> obj) {
        for (int i = obj.maxLevel; i >= 0; i--) {
            System.out.print("Level " + i + " : ");
            SkipListNode<String, String> cur = obj.head;
            while (cur.nexts.get(i) != null) {
                SkipListNode<String, String> next = cur.nexts.get(i);
                System.out.print("(" + next.key + " , " + next.value + ") ");
                cur = next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SkipListMap<String, String> test = new SkipListMap<>();
        printAll(test);
        System.out.println("======================");
        test.put("A", "10");
        printAll(test);
        System.out.println("======================");
        test.remove("A");
        printAll(test);
        System.out.println("======================");
        test.put("E", "E");
        test.put("B", "B");
        test.put("A", "A");
        test.put("F", "F");
        test.put("C", "C");
        test.put("D", "D");
        printAll(test);
        System.out.println("======================");
        System.out.println(test.containsKey("B"));
        System.out.println(test.containsKey("Z"));
        System.out.println(test.firstKey());
        System.out.println(test.lastKey());
        System.out.println(test.floorKey("D"));
        System.out.println(test.ceilingKey("D"));
        System.out.println("======================");
        test.remove("D");
        printAll(test);
        System.out.println("======================");
        System.out.println(test.floorKey("D"));
        System.out.println(test.ceilingKey("D"));
    }


}
