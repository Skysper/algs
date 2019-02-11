package com.skysper.algs;

/**
 * 从数组中查找最大的两个数
 * data range: [lo, hi)
 */
public class FindMaxTwo {

    public int[] find(int[] array, int lo, int hi) {
        if(hi - lo < 2) {
            return null;
        }

        //total: hi - lo - 1
        int index1 = lo;
        for(int i = lo + 1; i < hi; i++) {
            if(array[index1] < array[i]) {
                index1 = i;
            }
        }

        //total: hi - lo - 2
        int index2 = lo;
        // index1 - lo - 1
        for(int i= lo + 1; i < index1; i++) {
            if(array[index2] < array[i]) {
                index2 = i;
            }
        }
        //hi - index1 - 1
        for(int i=index1 + 1; i < hi; i++) {
            if(array[index2] < array[i]) {
                index2 = i;
            }
        }

        // n = hi - lo;
        // total: 2n - 3
        return new int[]{array[index1], array[index2]};
    }
}
