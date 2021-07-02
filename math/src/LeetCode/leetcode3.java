package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/15 5:42 下午
 * @description
 */
public class leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        int[] num = new int[256];
        while (j < s.length()) {
            i = Math.max(i, num[s.charAt(j)]);
            max = Math.max(max, j - i + 1);
            num[s.charAt(j)] = ++j;
        }
        return max;


//        int i = 0;
//        int j = 0;
//        int max = 0;
//        int[] ch = new int[256];
//        while (j < s.length()) {
//            //获取当前最左边的值，左边的需要用当前的数据进行查询
//            //每次用当期的位置，更新之前的数据。
//            i = Math.max(i, s.charAt(j));
//            max = Math.max(max, j - i + 1);
//            ch[s.charAt(j)] = ++j;
//        }
//        return max;
    }
}