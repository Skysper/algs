package com.skysper.sort;

/**
 * @author skysper
 * @date 2022-02-28 13:24
 */
public class SortUtil {
    public static void swap(int[] array, int i, int j) {
        if(array[i]!= array[j]) {
            array[i] = array[i] ^ array[j];
            array[j] = array[i] ^ array[j];
            array[i] = array[i] ^ array[j];
        }
    }


    public static void normalSwap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }




}
