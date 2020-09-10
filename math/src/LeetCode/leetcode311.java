package LeetCode;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/3 2:39 下午
 * @description
 */
public class leetcode311 {
    public boolean isValidSerialization(String preorder) {
//        String[] cs = preorder.split(",");
//        int res = help(cs, 0);
//        return res == -1 || res <= cs.length - 1 ? false : true;
//    }
//
//    private int help(String[] cs, int index) {
//        if (index >= cs.length) {
//            return -1;
//        }
//        if ("#".equals(cs[index])) {
//            return ++index;
//        }
//        index = help(cs, ++index);
//        if (index == -1) {
//            return index;
//        }
//        index = help(cs, index);
//        return index;
        int n = preorder.length();
        if (n == 0) {
            return true;
        }
        String[] arr = preorder.split(",");
        Stack<String> sk = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            sk.push(arr[i]);
            while (sk.size() >= 3
                    && sk.get(sk.size() - 1).equals("#")
                    && sk.get(sk.size() - 2).equals("#")) {
                sk.pop();
                sk.pop();
                if (sk.peek().equals("#")) {
                    return false;
                }
                sk.pop();
                sk.push("#");
            }
        }
        return sk.size()==1&&sk.peek().equals("#");
    }
}
