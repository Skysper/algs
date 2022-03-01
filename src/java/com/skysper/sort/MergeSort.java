package com.skysper.sort;

import com.skysper.util.DataUtil;
import com.skysper.util.Printer;

import java.util.Arrays;

/**
 *
 * @author skysper
 * @date 2022-03-01 22:12
 */
public class MergeSort {

    public static void sort(int[] arr) {

        process(arr, 0, arr.length - 1);

    }

    private static void process(int[] arr, int left, int right) {
        if(left == right) {
            return;
        }

        int mid = (left + right) / 2;

        process(arr, left, mid);
        process(arr, mid+1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int a = left;
        int b = mid + 1;

        int[] help = new int[right - left + 1];
        int helpIndex = 0;

        while(a <= mid && b <= right) {
            help[helpIndex++] = (arr[b] > arr[a]) ? arr[a++] : arr[b++];
        }

        while(a <= mid) {
            help[helpIndex++] = arr[a++];
        }

        while(b <= right) {
            help[helpIndex++] = arr[b++];
        }

        for(int i =0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] array = DataUtil.mockIntegerArray(50);

        int[] copy = DataUtil.copy(array);
        Arrays.sort(copy);

        Printer.printArray(array);
        sort(array);
        Printer.printArray(array);

        System.out.println(DataUtil.isEqual(copy, array));
    }
}
