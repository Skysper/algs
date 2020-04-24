```
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
```

最优解：
```
public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}
```
字符可进行额外扩展，只要字符是连续稳定的（也可以考虑使用位操作，继续降低空间使用）
对于不适宜使用数组表示的非连续字符，或特殊的Unicode字符，可以使用Map代替int[]



对字符首先进行排序，然后判断字符是否相同：
```
public class Solution {
	public boolean isAnagram(String s, String t) 
	{
	    char[] sChar = s.toCharArray();
	    char[] tChar = t.toCharArray();
	    
	    Arrays.sort(sChar);
	    Arrays.sort(tChar);
	    
	    return Arrays.equals(sChar, tChar);   
	}
}
```
