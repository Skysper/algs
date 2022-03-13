package com.skysper.sort;

import com.skysper.common.Heap;
import com.skysper.util.DataUtil;
import com.skysper.util.Printer;

import java.util.Arrays;

/**
 * 堆排序
 * @author skysper
 * @date 2022-03-05 00:23
 */
public class HeapSort {

    /**
     * 无稳定性
     * @param arr
     */
    public static void sort(int[] arr) {
        Heap heap = new Heap(arr.length);
        for (int val : arr) {
            heap.add(val);
        }

        for(int i = 0; i < arr.length; i++) {
            arr[i] = heap.poll();
            Printer.printArray(heap.array);
        }
    }

    public static void main(String[] args) {
        int[] array = DataUtil.mockIntegerArray(10);
        int[] copy = DataUtil.copy(array);
        Arrays.sort(copy);

        Printer.printArray(array);
        sort(array);
        Printer.printArray(array);

        System.out.println(DataUtil.isEqual(copy, array));

    }
}
