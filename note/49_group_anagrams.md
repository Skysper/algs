给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
```
输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
```

解法一：
将String按照字符ascii顺序映射成统一序的String，作为Map的key键，以此归类进行分组
时间复杂度:O(N*K)
K为内部每个单独String循环的时间复杂度

空间复杂度:为O(1)

```
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs) {
            int[] array = new int[26];
            for(int i =0;i < s.length();i++) {
                array[s.charAt(i) -'a']++;
            }
            String sHash = Arrays.toString(array);
            if(!map.containsKey(sHash)) {
                map.put(sHash, new ArrayList<String>());
            }
            map.get(sHash).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
```

解法二：
对String的字符数组进行排序，或者统一序的String作为Map的key键，以此归类进行分组
时间复杂度:O(N*KlogK)
空间复杂度为O(K)
```
public List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) return new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        String keyStr = String.valueOf(ca);
        if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
        map.get(keyStr).add(s);
    }
    return new ArrayList<>(map.values());
}
```

