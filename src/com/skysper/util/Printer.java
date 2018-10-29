package com.skysper.util;

/**
 * 打印帮助类
 * @author wupengfei
 */
public class Printer {

    public static void printArray(Object[] array) {
        System.out.print("[");
        for (Object item : array) {
            System.out.print(item);
            System.out.print(" ");
        }
        System.out.println("]");
    }

}
