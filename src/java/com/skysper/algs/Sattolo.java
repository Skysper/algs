package com.skysper.algs;

import java.util.Random;

/**
 * see at #link https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#Sattolo's_algorithm
 * @author skysper
 */
public class Sattolo {

    public static void shuffle(Object[] original) {
        Random random = new Random();
        int i = original.length;
        while(i > 1) {
            i = i - 1;
            int j = random.nextInt(i);
            Object temp = original[j];
            original[j] = original[i];
            original[i] = temp;
        }
    }

}
