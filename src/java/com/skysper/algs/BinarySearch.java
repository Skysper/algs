package com.skysper.algs;

import com.skysper.util.Printer;


/**
 * @author skysper
 */
public class BinarySearch {
    /**
     * 二分查找
     * 时间复杂度:lg(n)
     * @param array
     * @param key 查找项
     * @return 返回匹配结果的索引，如果未匹配到，则返回-1
     */
    public static int search(int[] array, int key) {
        int min = 0;
        int max = array.length - 1;

        while(min <= max) {
            int mid = (min + max) / 2;
            Printer.logDebug("binary search query once:" + array[mid]);
            if(array[mid] > key) {
                max = mid - 1;
            } else if(array[mid] < key) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找 >= num 最左边的值
     * @param array
     * @param num
     * @return
     */
    public static int searchNearestLeft(int[] array, int num) {

        int L = 0;
        int R = array.length - 1;

        while(L <= R) {
            int mid = L + ((R - L) >> 1);

            if(array[mid] >= num) {
                R = mid - 1;
            } else if(array[mid] < num) {
                L = mid + 1;
            }
        }

        return (R < array.length - 1) ? (R+1) : -1;
    }

    public static int searchNearestRight(int[] arr, int num) {
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        while(L <= R) {
            int mid = L + ((R - L) >> 1);
            if(arr[mid] > num) {
                R = mid - 1;
            } else if(arr[mid] <= num) {
                L = mid + 1;
                index = mid;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        int[] arr = new int[] {1,2,2,4,5,6,6,7,7,7,9,10};
        //arr = new int[]{2,2};

        System.out.println(searchNearestLeft(arr, 3));

        System.out.println(searchNearestRight(arr, 7));
    }














}
