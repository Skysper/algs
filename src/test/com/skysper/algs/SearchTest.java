package com.skysper.algs;

import com.skysper.algs.BinarySearch;
import com.skysper.util.Printer;

public class SearchTest {

    public static void main(String[] args) {

        int[] array = {2, 10, 23, 46, 99, 173, 223, 432, 550, 992, 1934, 2314};
        Printer.printArray(array);
        int index = BinarySearch.search(array, 23);
        System.out.println("index find: " + index);

        index = BinarySearch.search(array, 66);
        System.out.println("index find: " + index);

    }

}
