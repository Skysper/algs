package com.skysper.sort;

import com.skysper.util.Printer;

/**
 * @author skysper
 * @date 2022-02-28 13:16
 */
public class BubbleSort {

    /**
     * 有稳定性
     * @param array
     */
    public static void sort(int[] array) {
        if(array.length <= 1) {
            return;
        }

        for (int i = array.length - 1; i  > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(array[j] > array[j + 1]) {
                    SortUtil.swap(array, j, j+1);
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{4,3,6,2,7,9,10,43,22,8};
        Printer.printArray(array);

        BubbleSort.sort(array);

        Printer.printArray(array);
    }
}
