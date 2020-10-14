package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/15 2:01 下午
 * @description
 */
public class leetcode93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        help(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void help(String s, int index, List<String> list, List<String> res) {
        if (list.size() == 4) {
            if (index == s.length()) {
                res.add(String.join(".", list));
            }
        }
        for (int i = 1; i <= 3; i++) {
            if (index + i >= s.length()) {
                break;
            }
            String curr = s.substring(index, index + i);
            if ((curr.startsWith("0") && curr.length() > 1) ||
                    (i == 3 && Integer.parseInt(curr) > 255)) {
                continue;
            }

            list.add(curr);
            help(s, index+i, list, res);
            list.remove(list.size() - 1);
        }

    }
}
