package com.skysper.common;

/**
 * 线段树
 * @author skysper
 * @date 2022-03-14 13:22
 */
public class SegmentTree {

    private int[] array;
    private int[] sum;
    private int[] add;
    private boolean[] update;
    private int[] updateVal;


    public SegmentTree(int[] arr) {
        int len = arr.length + 1;
        this.array = new int[len];
        for(int i = 0; i < arr.length;i++) {
            this.array[i+1] = arr[i];
        }

        // 4倍的数据空间
        this.sum = new int[len >> 2];
        this.add = new int[len >> 2];
        this.update = new boolean[len >> 2];
        this.updateVal = new int[len >> 2];
    }

    private void pushUp(int rt) {
        int a = rt << 1;
        int b = rt << 1 + 1;

        sum[rt] = sum[a] + sum[b];
    }

    private void build(int L, int R, int rt) {
        if(L == R) {
            sum[rt] = array[L];
            return;
        }

        int mid = L + ((R- L) >> 1);

        build(L, mid, rt << 1);
        build(mid + 1, R, rt << 1 + 1);
        pushUp(rt);
    }

    private void sum(int L, int R, int C) {

    }

    private void process(int L, int R, int C, int ls, int es, int rt) {
        if(L <= ls && R >= es) {
            add[rt] += C;
            sum[rt] += (es - ls + 1) * C;
            return;
        }
        int mid = ls + ((es - ls) >> 1);
        if(add[rt] > 0) {
            pushDown(mid - ls + 1, es - mid, rt);
        }


        if(mid > L && mid <= R) {

            process(L, R, C, ls, mid, rt >> 1);
        }

        if(mid + 1 > L  && R >= (mid + 1)) {
            process(L, R, C, mid + 1, es, rt >> 1 + 1);
        }
        pushUp(rt);

    }

    private void pushDown(int ln, int rn, int rt) {

        if(add[rt] > 0) {
            this.sum[rt >> 1] += ln * add[rt];
            this.sum[rt >> 1 + 1] += rn * add[rt];
            this.add[rt >> 1] += add[rt];
            this.add[rt >> 1 + 1] += add[rt];
            this.add[rt] = 0;
        }
    }

    public static void main(String[] args) {

    }
}
