package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/8 10:59 下午
 * @description
 */
public class leetcode17 {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return list;
        }
        help("", digits);
        return list;
    }

    private void help(String s, String digits) {
        if (digits.length() == 0) {
            list.add(s);
            return;
        }
        String curr = digits.substring(0, 1);
        String letter = phone.get(curr);
        for (int i = 0; i < letter.length(); i++) {
            char c = letter.charAt(i);
            help(curr + c, digits.substring(1));
        }
    }
}
















