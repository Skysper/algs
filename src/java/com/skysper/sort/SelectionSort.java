package com.skysper.sort;

import com.skysper.util.DataUtil;
import com.skysper.util.Printer;

/**
 * @author skysper
 * @date 2022-02-28 13:24
 */
public class SelectionSort {

    public static void sort(int[] arr) {

        if(arr == null || arr.length < 2) {
            return;
        }

        for(int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = DataUtil.mockIntegerArray(10);
        Printer.printArray(array);
        SelectionSort.sort(array);
        Printer.printArray(array);
    }

}
