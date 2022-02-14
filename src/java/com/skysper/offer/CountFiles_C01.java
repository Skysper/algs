package com.skysper.offer;

import java.io.File;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author skysper
 * @date 2022-02-14 22:59
 */
public class CountFiles_C01 {

    public static int getFileNumbers(String path) {

        File file = new File(path);
        if(!file.isDirectory() && !file.isFile()) {
            return 0;
        }

        if(file.isFile()) {
            return 1;
        }

        Queue<File> deque = new LinkedList<>();
        deque.add(file);

        int count = 0;

        while(!deque.isEmpty()) {
            File folder = deque.poll();
            for(File f : folder.listFiles()) {
                if(f.isDirectory()) {
                    deque.add(f);
                } else if(f.isFile()) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(getFileNumbers("/Users/xueqiu/Desktop"));
    }

}
