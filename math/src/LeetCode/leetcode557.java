package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2021/12/28 10:39 PM
 * @description
 */
public class leetcode557 {
    public String reverseWords(String s) {
        if (s.trim().length() <= 1) {
            return s;
        }
        String[] str = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            char[] ch = str[i].toCharArray();
            ch = rever(ch);
            res.append(ch).append(" ");
        }
        return res.toString().trim();
    }

    public char[] rever(char[] ch) {
        if (ch.length <= 1) {
            return ch;
        }
        int i = 0;
        int j = ch.length - 1;
        while (i < j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        return ch;

    }

}
