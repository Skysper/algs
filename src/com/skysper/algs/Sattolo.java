package com.skysper.algs;

import java.util.Random;

/**
 * see at #link https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#Sattolo's_algorithm
 * @author wupengfei
 */
public class Sattolo {

    public static void shuffle(Object[] original) {
        int i = original.length;
        while(i > 1) {
            i = i - 1;
            int j = new Random().nextInt(i);
            Object temp = original[j];
            original[j] = original[i];
            original[i] = temp;
        }
    }

}
