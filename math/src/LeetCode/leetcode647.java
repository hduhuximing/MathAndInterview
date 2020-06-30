package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/5 2:35 下午
 * @description
 */
public class leetcode647 {
    private int sum = 0;

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        for (int i = 0; i <s.length(); i++) {
            count(s, i, i);
            count(s, i, i + 1);
        }
        return sum;
    }

    private void count(String s, int i, int j) {
        while (i >= 0
                && j <= s.length() - 1
                && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            sum++;
        }
    }

    public static void main(String[] args) {
        leetcode647 le=new leetcode647();
        int abc = le.countSubstrings("abc");
        System.out.println(abc);
    }
}
