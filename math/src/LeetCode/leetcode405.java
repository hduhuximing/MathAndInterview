package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/19 10:29 上午
 * @description
 */
public class leetcode405 {
    public static void main(String[] args) {
        System.out.println(toHex(26));
    }
    public static String toHex(int num) {
        StringBuilder str = new StringBuilder();
        char[] ch = "0123456789abcdef".toCharArray();
        while (num != 0) {
            int index = num % 16;
            str.append(ch[index]);
            num >>>= 4;
        }
        if (str.length() == 0) {
            return "0";
        }
        return str.reverse().toString();
    }
}
