package com.skysper.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成括号
 * @author skysper
 * @date 2022-06-19 23:18
 */
public class P_22_Generate_Parentheses {

    public List<String> generateParenthesis(int n) {
        char[] path = new char[n * 2];
        List<String> result = new ArrayList<>();
        process(path, 0, n, 0, result);
        return result;
    }

    public void process(char[] path, int index, int leftLeft, int leftRight, List<String> result) {
        if(index == path.length) {
            result.add(String.valueOf(path));
        } else {
            if(leftLeft > 0) {
                path[index] = '(';
                process(path, index + 1, leftLeft - 1, leftRight + 1, result);
            }
            if(leftRight > 0) {
                path[index]= ')';
                process(path, index + 1, leftLeft, leftRight - 1, result);
            }
        }
    }
}
