package LeetCode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/15 4:35 下午
 * @description 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 */
public class leetcode438 {
    public static List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || p == null || s.length() < p.length()) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] ch = new int[26];
        char[] array = p.toCharArray();
        for (int i = 0; i < array.length; i++) {
            ch[array[i] - 'a']++;
        }
        int start = 0;
        int end = 0;
        int count = p.length();
        //扩充成登于p长度的窗口
        for (; end < p.length(); end++) {
            ch[array[end] - 'a']--;
            if (ch[array[end] - 'a'] >= 0) {
                count--;
            }
        }
        if (count == 0) {
            list.add(0);
        }
        //进行添加删除操作
        for (; end < s.length(); end++) {
            //左边出去
            char temp = s.charAt(start++);
            if (ch[temp - 'a']++ >= 0) {
                count++;
            }
            //右边的拿进来一个
            //新进来的数据判断，如果是p中的数据，就--
            temp = s.charAt(end);
            //命中
            if (--ch[temp - 'a'] >= 0) {
                count--;
            }
            if (count == 0)
                list.add(start);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);
    }
}