package com.skysper.leetcode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author skysper
 * @date 2022-01-18 22:15
 */
public class lps_5 {
    //manacher算法
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }

        char[] array = fillSharpe(s);
        int[] range = manacher(array);

        char[] result = new char[range[0]];

        int index = 0;
        for(int i = range[1]; i < range[2]; i++ ) {
            if(array[i] != '#') {
                result[index] = array[i];
                index++;
            }
        }
        return new String(result);

    }

    private char[] fillSharpe(String s) {
        char[] arr = s.toCharArray();
        char[] result = new char[2 * arr.length + 1];

        for(int i=0; i < arr.length; i++) {
            result[2 * i] = '#';
            result[2 * i + 1] = arr[i];
        }
        //多填充一个字符
        result[2 * arr.length] = '#';

        return result;
    }


    private int[] manacher(char[] array) {
        int max = 0;
        //最右回文右边界对称中心C
        int C = -1;
        //回文半径数组
        int[] parr = new int[array.length];
        // R表示第一个不匹配的字符，最右回文边界
        int R = -1;
        int maxI = 0;

        for(int i = 0; i< array.length; i++) {
            //i在R的左侧
            //R-i为场景 / parr[2*C - i]为对称点
            parr[i] = R > i ? Math.min(parr[2 * C - i], R - i) : 1;
            while ( i + parr[i] < array.length && i - parr[i] > - 1) {
                if(array[i + parr[i]] == array[i - parr[i]]) {
                    parr[i]++;
                } else {
                    break;
                }
            }
            if(i + parr[i] > R) {
                R = i + parr[i];
                C = i;
            }
            if(parr[i] > max) {
                max = parr[i];
                maxI = i;
            }
        }

        return new int[] {max - 1, maxI - max + 1, maxI + max - 1};
    }
}
