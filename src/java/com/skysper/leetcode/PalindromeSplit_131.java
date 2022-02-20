package com.skysper.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author skysper
 * @date 2022-02-20 23:45
 */
public class PalindromeSplit_131 {

    public List<List<String>> partition(String s) {
        char[] array = s.toCharArray();
        List<List<String>> list = new ArrayList<>();
        process(array, 0, list, new ArrayList<>());
        return list;
    }

    public void process(char[] array, int index, List<List<String>> list, List<String> temp) {
        if(index == array.length) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index; i < array.length; i++) {
            if(isPalindrome(array, index, i)) {
                char[] newChar = new char[i + 1 -index];
                System.arraycopy(array, index, newChar, 0, i+1 -index);
                temp.add(new String(newChar));
                process(array, i + 1, list, temp);
                temp.remove(temp.size() - 1);
            }
        }

    }

    //可优化项目
    //使用dp进行记忆
    private boolean isPalindrome(char[] array, int start, int end) {
        while(start <= end) {
            if(array[start] == array[end]) {
                start++;
                end --;
            } else {
                return false;
            }
        }
        return true;
    }

}
