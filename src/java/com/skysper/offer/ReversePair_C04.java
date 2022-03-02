package com.skysper.offer;

import com.skysper.util.DataUtil;
import com.skysper.util.Printer;

/**
 * @author skysper
 * @date 2022-03-01 22:39
 */
public class ReversePair_C04 {

    /**
     * 计算数组中的逆序对数量
     * @param arr
     * @return
     */
    public static int reversePair(int[] arr) {

        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);

    }

    private static int process(int[] arr, int left, int right) {
        if(left == right) {
            return 0;
        }

        //精简忽略溢出的考虑
        int mid = (left + right) / 2;

        return process(arr, left, mid) + process(arr, mid + 1, right)
                + merge(arr, left, mid, right);
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        //
        int[] help = new int[right - left + 1];

        int a = mid;
        int b = right;

        int res = 0;
        int index = help.length - 1;
        //需要逆序处理，才能锁定所有的范围内的逆序对
        while(a >= left && b > mid) {
            res += arr[a] > arr[b] ? (b - mid) : 0;
            help[index--] = arr[a] > arr[b] ? arr[a--] : arr[b--];
        }

        while (a >= left) {
            help[index--] = arr[a--];
        }
        while (b > mid) {
            help[index--] = arr[b--];
        }
        for (index = 0; index < help.length; index++) {
            arr[left + index] = help[index];
        }

        return res;

    }

    //for check
    public static int comparator(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = DataUtil.mockIntegerArray(30);

        int[] copy = DataUtil.copy(array);

        Printer.printArray(array);
        int res = reversePair(array);

        System.out.println("res:" + res + ":" + (res == comparator(copy)));



        Printer.printArray(array);
    }

}
