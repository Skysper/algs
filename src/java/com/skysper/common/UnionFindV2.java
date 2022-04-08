package com.skysper.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @see https://algs4.cs.princeton.edu/15uf/ for many new implements.
 * @author skysper
 * @date 2022-04-02 13:17
 */
public class UnionFindV2 {

    private int[] parents;
    private int sets;

    void makeSet(int v) {
        parents[v] = v;
    }


    public UnionFindV2(int n) {

        this.parents = new int[n];

        for (int i = 0; i < n; i++) {
            makeSet(i);
        }

        sets = n;
    }

    public int findFather(int index) {
        int p = parents[index];

        while (p != parents[p]) {
            p = parents[p];
        }

        while(p != index) {
            int newIndex = parents[index];
            parents[index] = p;
            index = newIndex;
        }
        return p;
    }

    public boolean isSameSet(int indexA, int indexB) {
        return findFather(indexA) == findFather(indexB);
    }

    public void union(int indexA, int indexB) {

        int af = findFather(indexA);
        int bf = findFather(indexB);

        if (af != bf) {
            parents[bf] = af;
            sets--;
        }
    }

    public int sets() {
        return sets;
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            array.add(i);
        }

        UnionFindV2 uf = new UnionFindV2(10);

        uf.union(2, 4);
        System.out.println(uf.sets());

        uf.union(3, 6);
        System.out.println(uf.sets());

        uf.union(2, 5);
        System.out.println(uf.sets());


        System.out.println("6的father:" + uf.findFather(6));
        uf.union(5, 6);
        System.out.println("6的father:" + uf.findFather(6));

        System.out.println(uf.isSameSet(6,3));

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i) + ":" + uf.findFather(i));
        }


        System.out.println(uf.isSameSet(2,5));
        System.out.println(uf.isSameSet(9,3));

    }
}