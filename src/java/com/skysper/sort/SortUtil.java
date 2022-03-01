package com.skysper.sort;

/**
 * @author skysper
 * @date 2022-02-28 13:24
 */
public class SortUtil {
    public static void swap(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }




}
