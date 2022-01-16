package com.skysper.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author skysper
 * @date 2022-01-16 17:53
 */
public class Lru_Cache_146 {
    /**
     * 直接使用LinkedHashMap
     */
    static class LRUCacheWithLinkedHashMap extends LinkedHashMap<Integer, Integer> {

        private int capacity;

        public LRUCacheWithLinkedHashMap(int capacity) {
            //设定容量、负载因子和访问顺序
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            if(!super.containsKey(key)) {
                return -1;
            }
            return super.get(key);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
            //指定淘汰策略
            return size() > capacity;
        }
    }


    static class LRUCache {

        static class Node {
            Node before;
            Node after;
            int value;
            int key;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private Node head;
        private Node tail;

        int size;
        int capacity;

        Map<Integer, Node> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            size = 0;
            map = new HashMap<Integer, Node>(capacity);
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            moveToLastNode(node);
            return node.value;
        }

        /**
         * 删除头节点
         * @param node
         */
        private void deleteHead(Node node) {
            if(size == 1) {
                //存在一个节点，则直接删除
                head = tail = null;
            } else {
                //删除头节点
                head = head.after;
                head.before = null;
            }
            size--;
        }

        public void moveToLastNode(Node node) {
            //只有自己的时候 do nothing.
            if(size == 1) {
                return;
            }
            //中间节点
            if(tail != node && head != node) {
                Node a = node.after;
                Node b = node.before;
                b.after = a;
                a.before = b;
                node.after = null;
                node.before = tail;
                tail.after = node;
                tail = node;
            } else if (head == node && tail != node) {
                //处理头节点
                head = head.after;
                head.before = null;
                node.after = null;

                node.before = tail;
                tail.after = node;
                tail = node;
            }
        }

        public void put(int key, int value) {
            //存在时移除到尾部
            //不存在时，创建，如果没有节点，则设置为头尾节点
            //否则，则追加到末尾节点
            if(map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                moveToLastNode(node);
            } else {
                if(size == this.capacity) {
                    Node node = head;
                    deleteHead(head);
                    map.remove(node.key);
                }

                Node node = new Node(key, value);
                if(head == null) {
                    head = node;
                    tail = node;
                } else {
                    node.before = tail;
                    tail.after = node;
                    node.after = null;
                    tail = node;
                }
                map.put(key, node);
                size++;
            }
        }
    }
}
