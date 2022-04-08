package com.skysper.common;

/**
 * @author skysper
 * @date 2022-04-03 07:53
 */
public class KMP {


    public int strStr(String source, String find) {
        char[] sourceArray = source.toCharArray();
        char[] findArray = find.toCharArray();

        int[] nextArray = generateNextArray(findArray);

        int i = 0;
        int j = 0;

        while(i < sourceArray.length && j < findArray.length) {
            if(sourceArray[i] == findArray[j]) {
                i++;
                j++;
            } else if(nextArray[j] == -1) {
                i++;
            } else {
                j = nextArray[j];
            }
        }

        return  j == findArray.length ? i - j : -1;
    }

    private int[] generateNextArray(char[] target) {
        if(target.length == 1) {
            return new int[]{-1};
        }
        if(target.length == 2){
            return new int[]{-1, 0};
        }
        int[] next = new int[target.length];

        next[0] = -1;
        next[1] = 0;
        next[2] = target[0] == target[1] ? 1 : 0;

        int len = target.length;

        int index = 2;

        int c = next[index - 1];
        while(index < len) {
            if(target[c] == target[index - 1]) {
                next[index++] = ++c;
            } else if(next[c] == -1) {
                next[index++] = 0;
            } else {
                c = next[c];
            }
        }

        return next;

    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        int index = kmp.strStr("cmababcaababad", "ababa");
        System.out.println(index);
    }


}
