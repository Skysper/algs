package com.skysper.common;

import java.util.*;

/**
 * @author skysper
 * @date 2022-04-01 17:25
 */
public class UnionFindV1<V> {

    public class Node<V> {
        V value;
        public Node(V v) {
            this.value = v;
        }
    }

    private HashMap<V, Node<V>> nodes;

    private HashMap<Node<V>, Node<V>> parents;
    private HashMap<Node<V>, Integer> sizeMap;


    public UnionFindV1(List<V> array) {
        nodes = new HashMap<>();
        parents = new HashMap<>();
        sizeMap = new HashMap<>();

        for(int i = 0; i < array.size(); i++) {
            Node<V> node = new Node<V>(array.get(i));
            nodes.put(array.get(i), node);
            parents.put(node, node);
            sizeMap.put(node, 1);
        }
    }

    public Node<V> findFather(Node<V> cur) {
        Deque<Node<V>> stack = new LinkedList<>();

        while(cur != parents.get(cur)) {
            stack.push(cur);
            cur = parents.get(cur);
        }

        while(!stack.isEmpty()) {
            parents.put(stack.pop(), cur);
        }

        return cur;
    }

    public boolean isSameSet(V a, V b) {
        return findFather(nodes.get(a)) == findFather(nodes.get(b));
    }

    public void union(V a, V b) {
        Node<V> aNode = nodes.get(a);
        Node<V> bNode = nodes.get(b);

        Node<V> af = findFather(aNode);
        Node<V> bf = findFather(bNode);

        if(af == bf) {
            return;
        } else {
            int aSize = sizeMap.get(af);
            int bSize = sizeMap.get(bf);

            Node<V> big = aSize >= bSize ? af : bf;
            Node<V> small = big == af ? bf : af;

            parents.put(small, big);

            sizeMap.put(big, aSize + bSize);
            sizeMap.remove(small);
        }
    }

    public int sets() {
        return sizeMap.size();
    }


    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();

        for(int i =0; i< 10; i++) {
            array.add(i);
        }

        UnionFindV1<Integer> uf = new UnionFindV1<>(array);

        uf.union(2,4);
        System.out.println(uf.sets());

        uf.union(3,6);
        System.out.println(uf.sets());

        uf.union(2,5);
        System.out.println(uf.sets());

        uf.union(5,6);
        System.out.println(uf.sets());

        for(int i =0 ;i < array.size();i++) {
            System.out.println(array.get(i) + ":" + uf.findFather(uf.nodes.get(array.get(i))).value);
        }

    }




}
