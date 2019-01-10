package com.skysper.algs;

import com.skysper.ConstPool;
import com.skysper.algs.Sattolo;
import com.skysper.util.Printer;

public class SattoloTest {

    public static void main(String[] args) {
        for(int i = 0; i < ConstPool.TEN; i++){
            Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            Sattolo.shuffle(array);
            Printer.printArray(array);
        }
    }

}
