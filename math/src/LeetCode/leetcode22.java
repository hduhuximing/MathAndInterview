package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class leetcode22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        help("", list, n, 0, 0);
        return list;
    }

    private void help(String s, List<String> list, int n, int left, int right) {
        if (s.length() == 2 * n) {
            list.add(s);
            return;
        }
        if (left < n) {
            help(s + "(", list, n, left + 1, right);
        }
        if (right < left) {
            help(s + ")", list, n, left, right + 1);
        }
    }
}
