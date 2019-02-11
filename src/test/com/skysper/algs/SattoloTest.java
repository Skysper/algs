package com.skysper.algs;

import com.skysper.ConstPool;
import com.skysper.util.Printer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

@RunWith(JUnit4ClassRunner.class)
public class SattoloTest {

    @Test
    public void test(){
        Integer m = null;
        if(Integer.valueOf(2).equals(m)){
            System.out.print(1);
        }
    }

    @Test
    public void showResult() {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for(int i = 0; i < ConstPool.TEN; i++){
            Sattolo.shuffle(array);
            Printer.printArray(array);
        }
    }

}
