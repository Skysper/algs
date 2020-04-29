```
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

 

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."
```

全使用字符数组，O(n)的时间复杂度的循环判定
```
class Solution {
    public String replaceSpace(String s) {
        char[] array = new char[s.length() * 3];
        char[] origin = s.toCharArray();
        int i=0;
        for(char c : origin) {
            if(c == ' ') {
                array[i++] = '%';
                array[i++] ='2';
                array[i++] = '0';
            } else array[i++] = c;
        }
        return new String(array, 0, i);
    }
}
```
