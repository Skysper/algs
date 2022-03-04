package com.skysper.sort;

import com.skysper.util.DataUtil;
import com.skysper.util.Printer;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author skysper
 * @date 2022-03-03 07:40
 */
public class QuickSort {

    public static void sort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }

        process3(arr, 0, arr.length-1);

    }

    /**
     * 使用最右侧数据作为基准进行处理
     * @param arr
     * @param left
     * @param right
     */
    public static void process1(int[] arr, int left, int right) {

        int index = partion1(arr, left, right);
        if(index == -1) {
            return;
        }
        process1(arr, left, index - 1);
        process1(arr, index+1, right);
    }

    /**
     * 随机选择作为基准
     * @param arr
     * @param left
     * @param right
     */
    public static void process2(int[] arr, int left, int right) {

        int index = partion2(arr, left, right);
        if(index == -1) {
            return;
        }
        process2(arr, left, index - 1);
        process2(arr, index+1, right);
    }

    /**
     * 返回中间==的数据区间
     * @param arr
     * @param left
     * @param right
     */
    public static void process3(int[] arr, int left, int right) {

        int[] array = partion3(arr, left, right);
        int newLeft = array[0];
        int newRight = array[1];

        if(newLeft != -1) {
            process3(arr, left, newLeft - 1);
        }

        if(newRight != -1) {
            process3(arr, newRight + 1, right);
        }
    }

    private static int[] partion3(int[] arr, int left, int right) {
        if(left > right) {
            return new int[]{ -1, -1 };
        }
        if(left == right) {
            return new int[] {left, right};
        }
        int less = left - 1;
        int more = right;

//        int index = left;
//
//        while(index < more) {
//            if(arr[index] < arr[right]) {
//                SortUtil.swap(arr, index++, ++less);
//            } else if(arr[index] > arr[right]) {
//                SortUtil.swap(arr, index, --more);
//            } else {
//                index++;
//            }
//        }

        for(int i = left; i < more; i++) {
            if(arr[i] < arr[right]) {
                SortUtil.swap(arr, i, ++less);
            } else if(arr[i] > arr[right]) {
                SortUtil.swap(arr, i, --more);
                i=i-1;
            }
        }
        SortUtil.swap(arr, more, right);
        return new int[] {less + 1, more};
    }



    private static int partion2(int[] arr, int left, int right) {
        if(left > right) {
            return -1;
        }
        if(left == right) {
            return left;
        }
        int less = left - 1;
        int random = ThreadLocalRandom.current().nextInt(left, right + 1);
        SortUtil.swap(arr, random, right);
        for(int i = left; i < right; i++) {
            if(arr[i] < arr[right]) {
                SortUtil.swap(arr, i, ++less);
            }
        }
        SortUtil.swap(arr, ++less, right);
        return less;
    }


    private static int partion1(int[] arr, int left, int right) {
        if(left > right) {
            return -1;
        }
        if(left == right) {
            return left;
        }
        int less = left - 1;

        for(int i = left; i < right; i++) {
            if(arr[i] < arr[right]) {
                SortUtil.swap(arr, i , ++less);
            }
        }
        SortUtil.swap(arr, ++less, right);
        return less;
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
