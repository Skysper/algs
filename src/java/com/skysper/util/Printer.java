package com.skysper.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 打印帮助类
 * @author skysper
 */
public class Printer {

    public static void printArray(List array) {
        System.out.print("[");
        for (Object item : array) {
            System.out.print(item);
            System.out.print(" ");
        }
        System.out.println("]");
    }

    public static void printArray(Object[] array) {
        System.out.print("[");
        for (Object item : array) {
            System.out.print(item);
            System.out.print(" ");
        }
        System.out.println("]");
    }


    public static void printMatrix(int[][] array) {
        System.out.println("[");
        for (int[] item : array) {
            System.out.print("[");
            for(int n : item) {
                System.out.print(n);
                System.out.print(" ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int item : array) {
            System.out.print(item);
            System.out.print(" ");
        }
        System.out.println("]");
    }

    public static void logDebug(String message) {
        System.out.println(System.currentTimeMillis() + " [DEBUG] " + message);
    }
    public static  void logError(String message) {
        System.out.println(System.currentTimeMillis() + " [ERROR]" + message);
    }

}
