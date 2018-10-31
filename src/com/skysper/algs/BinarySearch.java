package com.skysper.algs;

import com.skysper.util.In;
import com.skysper.util.Printer;

import java.io.PrintWriter;

/**
 * @author wupengfei
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


}
