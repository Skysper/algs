package com.skysper.common;

import com.skysper.sort.SortUtil;
import com.skysper.util.Printer;

/**
 * 默认使用小根堆
 * @author skysper
 * @date 2022-03-05 00:14
 */
public class Heap {

    public int[] array;

    int cap;

    int size = 0;

    public Heap(int size) {
        this.cap = size;
        array = new int[size];
    }


    public void add(int val) {
        array[size++] = val;
        heapInsert();
    }

    public int poll() {
        int val = array[0];
        array[0] = array[--size];
        array[size] = 0;
        heapify();
        return val;
    }

    private void heapInsert() {
        int c = size - 1;
        int p = (c - 1) / 2;

        while(array[p] > array[c]) {
            SortUtil.swap(array, p, c);
            c = p;
            p = (c - 1) / 2;
        }
        Printer.printArray(array);
        System.out.println("========");
    }

    private void heapify() {
        int index = 0;
        int left = index * 2 + 1;

        while(left < this.size) {

            int largest = left + 1 < this.size && array[left + 1] < array[left] ? left + 1 : left;
            largest = array[largest] < array[index] ? largest : index;

            if(largest == index) {
                break;
            }

            SortUtil.swap(array, index, largest);

            index = largest;

            left = index * 2 + 1;
        }
    }

}