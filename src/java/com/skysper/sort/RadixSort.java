package com.skysper.sort;

import com.skysper.util.DataUtil;
import com.skysper.util.Printer;

import java.util.Arrays;

/**
 * @author skysper
 * @date 2022-03-05 00:01
 */
public class RadixSort {

    public static void sort(int[] arr) {

        if(arr == null || arr.length < 2) {
            return;
        }

        int maxBits = getMaxBit(arr);

        radixSort(arr, maxBits);

    }

    private static int getDigits(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    private static void radixSort(int[] array, int maxBits) {
        //...
        int[] help = new int[array.length];

        for (int d=1; d <= maxBits; d++) {
            int[] count = new int[10];

            for(int i=0; i < array.length; i++) {
                int digit = getDigits(array[i], d);
                count[digit]++;
            }

            for(int i=1; i< count.length; i++) {
                count[i] = count[i] + count[i-1];
            }

            //已经排好序的，通过倒序的方式，可以保证顺序行
            //防止前序bit排好序的位置被再次打乱
            for (int i = array.length - 1; i >= 0; i--) {
                int j = getDigits(array[i], d);
                help[count[j] - 1] = array[i];
                count[j]--;
            }

            for(int i = 0; i < array.length;i++) {
                array[i] = help[i];
            }
        }
    }

    private static int getMaxBit(int[] arr) {

        int max = Integer.MIN_VALUE;
        for (int item : arr) {
            max = Math.max(item, max);
        }

        int bits = 0;
        while(max != 0) {
            max = max / 10;
            bits++;
        }

        return bits;
    }

    public static void main(String[] args) {
        int[] array = DataUtil.mockIntegerArray(55);

        int[] copy = DataUtil.copy(array);
        Arrays.sort(copy);

        Printer.printArray(array);
        sort(array);
        Printer.printArray(array);

        System.out.println(DataUtil.isEqual(copy, array));
    }
}
