package LeetCode;

import java.util.*;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/7 6:34 下午
 * @description 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return null;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String curr = String.valueOf(ch);
            if (!map.containsKey(curr)) {
                map.put(curr, new ArrayList<>());
            }
            map.get(curr).add(curr);
        }
        return new ArrayList<>(map.values());
    }
}
