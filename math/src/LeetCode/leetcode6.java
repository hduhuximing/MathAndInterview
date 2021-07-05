package LeetCode;


/**
 * @author ming
 * @version 1.0
 * @date 2020/7/7 8:53 下午
 * @description
 */
public class leetcode6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] str = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            str[i] = new StringBuilder();
        }
        boolean isUp = false;
        int row = 0;
        for (char c : s.toCharArray()) {
            str[row].append(c);
            if (row == 0 || row == numRows - 1) {
                isUp = !isUp;
            }
            row += isUp ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder stringBuilder : str) {
            res.append(stringBuilder);
        }
        return res.toString();
    }
}
