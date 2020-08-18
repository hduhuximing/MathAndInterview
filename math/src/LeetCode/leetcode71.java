package LeetCode;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/17 1:49 下午
 * @description
 */
public class leetcode71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!split[i].equals(".") && !split[i].equals("")) {
                stack.push(split[i]);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, "/" + stack.pop());
        }
        if (res.length() == 0) {
            return "/";
        } else {
            return res.toString();
        }
    }
}
