package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/4 9:46 下午
 * @description
 */
public class leetcode301 {
    Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        int deleteLeft = 0;
        int deleteRight = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                deleteLeft++;
            } else if (c == ')') {
                if (deleteLeft > 0) {
                    deleteLeft--;
                } else {
                    deleteRight++;
                }
            }
        }
        dfs(s, 0, 0, deleteLeft, deleteRight, new StringBuilder());
        list.addAll(set);
        return list;
    }

    private void dfs(String s, int index,
                     int leftCount, int deleteLeft,
                     int deleteRight, StringBuilder stringBuilder) {
        if (index == s.length()) {
            if (deleteLeft == 0 && deleteRight == 0) {
                set.add(stringBuilder.toString());
                return;
            }
        }
        char c = s.charAt(index);
        if (c == '(') {
            if (deleteLeft > 0) {
                dfs(s, index + 1, leftCount, deleteLeft - 1, deleteRight, stringBuilder);
            }
            stringBuilder.append(c);
            dfs(s, index + 1, leftCount + 1, deleteLeft, deleteRight, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } else if (c == ')') {
            if (deleteRight > 0)
                // 可以删除的右括号数大于0，一个分支是删除当前右括号
                dfs(s, index + 1, leftCount, deleteLeft, deleteRight - 1, stringBuilder);
            if (leftCount > 0) {
                // 前面有足够的左括号和当前的右括号匹配，才可以走到另一个分支保留当前右括号
                stringBuilder.append(c);
                dfs(s, index + 1, leftCount - 1, deleteLeft, deleteRight, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        } else {
            stringBuilder.append(c);
            dfs(s, index + 1, leftCount, deleteLeft, deleteRight, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
