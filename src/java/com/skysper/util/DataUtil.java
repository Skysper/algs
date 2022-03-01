package com.skysper.util;

/**
 * @author skysper
 * @date 2022-03-01 12:52
 */
public class DataUtil {

    public static int[] copy(int[] array) {
        int[] newArr = new int[array.length];

        for(int i=0;i<array.length; i++) {
            newArr[i] = array[i];
        }
        return newArr;
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static boolean isEqual(int[] arr1, int[] arr2) {
        //忽略null的情况
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }


    public static int[] mockIntegerArray(int len) {
        int[] arr = new int[len];
        for(int i=0;i < len; i++) {
            arr[i] = StdRandom.uniform(Math.max(100,len));
        }
        return arr;
    }


    public static long[] mockLongArray(int len) {
        long[] arr = new long[len];
        for(int i=0;i < len; i++) {
            arr[i] = StdRandom.uniform(Math.max(100,len));
        }
        return arr;
    }

}
