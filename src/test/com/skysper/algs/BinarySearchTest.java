package com.skysper.algs;

import com.skysper.util.Printer;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(JUnit4ClassRunner.class)
public class BinarySearchTest {

    private static BinarySearch binarySearch;

    @BeforeClass
    public static void setUp(){
        binarySearch = new BinarySearch();
    }

    @Test
    public void search() {
        int[] array = {2, 10, 23, 46, 99, 173, 223, 432, 550, 992, 1934, 2314};
        Printer.printArray(array);
        int index = BinarySearch.search(array, 23);
        assertEquals(2, index);
    }

}
