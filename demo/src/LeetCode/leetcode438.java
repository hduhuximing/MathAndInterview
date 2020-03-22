package LeetCode;


import java.util.ArrayList;
import java.util.LinkedList;
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
        List<Integer> list = new ArrayList<>();
        if (s == null
                || s.length() == 0
                || p == null
                || s.length() < p.length()) {
            return list;
        }
        int[] ch = new int[26];
        char[] array = p.toCharArray();
        for (char c : array) {
            ch[c - 'a']++;
        }
        int start = 0;
        int end = 0;
        int count = p.length();
        //扩充成登于p长度的窗口
        for (; end < p.length(); end++) {
            ch[s.charAt(end) - 'a']--;
            if (ch[s.charAt(end) - 'a'] >= 0) {
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
//        List<Integer> res = new LinkedList<>();
//        if (s == null || p == null || s.length() < p.length()){
//            return res;
//        }
//        int[] ch = new int[26];
//        //统计p串字符个数
//        for (char c : p.toCharArray()){
//            ch[c - 'a']++;
//        }
//        //把窗口扩成p串的长度
//        int start = 0, end = 0, rest = p.length();
//        for (; end < p.length(); end++) {
//            char temp = s.charAt(end);
//            ch[temp - 'a']--;
//            if (ch[temp - 'a'] >= 0){
//                rest--;
//            }
//        }
//        if (rest == 0){
//            res.add(0);
//        }
//        //开始一步一步向右移动窗口。
//        for(;end < s.length();end++) {
//            //左边的拿出来一个
//            //负数表示原来p中就没有的数据 所以不用++；
//            //如果大于等于0 表示当前匹配过的数据需要还回去
//            char temp = s.charAt(start);
//            if (ch[temp - 'a'] >= 0) {
//                rest++;
//            }
//            ch[temp - 'a']++;
//            start++;
//            //右边的拿进来一个
//            //新进来的数据判断，如果是p中的数据，就--
//            temp = s.charAt(end);
//            ch[temp - 'a']--;
//            //命中
//            if (ch[temp - 'a'] >= 0) {
//                rest--;
//            }
//            if (rest == 0)
//                res.add(start);
//        }
//        return res;
    }


    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("aa", "bb");
        System.out.println(anagrams);
    }
}