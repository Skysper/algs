package com.skysper.sort;

import com.skysper.util.Printer;

/**
 * 插入排序
 * @author sksyper
 * @date 2022-02-28 13:01
 */
public class InsertionSort {

    /**
     * 有稳定性
     * @param array
     */
    public void sort(int[] array) {
        if(array.length <= 1) {
            return;
        }

        for(int i=2; i < array.length; i++) {

            for(int j = i; j >=1; j--) {
                if(array[j] >= array[j-1]) {
                    break;
                } else {
                    SortUtil.swap(array, j , j -1);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{4,3,6,2,7,9,10,43,22,8};
        Printer.printArray(array);

        InsertionSort sorter = new InsertionSort();
        sorter.sort(array);

        Printer.printArray(array);
    }

}
