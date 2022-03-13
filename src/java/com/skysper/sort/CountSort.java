package com.skysper.sort;

import com.skysper.util.DataUtil;
import com.skysper.util.Printer;

import java.util.Arrays;

/**
 * 桶排序/计数排序
 * @author skysper
 * @date 2022-03-05 09:34
 */
public class CountSort {

    /**
     * 有稳定性
     * @param arr
     */
    public static void sort(int[] arr) {
        if(arr.length <= 1) {
            return;
        }
        
        int[] help = new int[100];
        for(int i = 0; i < arr.length; i++) {
            help[arr[i]]++;
        }

        int arrayIndex = 0;
        for(int i = 0; i<help.length;i++) {
            while(help[i] > 0) {
                arr[arrayIndex++] = i;
                help[i]--;
            }
        }

    }

    public static void main(String[] args) {
        int[] array = DataUtil.mockIntegerArray(30);
        int[] copy = DataUtil.copy(array);
        Arrays.sort(copy);

        Printer.printArray(array);
        sort(array);
        Printer.printArray(array);

        System.out.println(DataUtil.isEqual(copy, array));
    }
}
