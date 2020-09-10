package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/3 2:27 下午
 * @description
 */
public class leetcode316 {
    public String removeDuplicateLetters(String text) {

        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> seen = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            map.put(text.charAt(i), i);
        }
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!seen.contains(c)) {
                while (!stack.isEmpty()
                        && stack.peek() > c
                        && map.get(stack.peek()) > i) {
                    seen.remove(stack.pop());
                }
                seen.add(c);
                stack.push(c);
            }
        }
        StringBuilder ans = new StringBuilder(stack.size());
        //因为Stack类是继承Vector,所以可以用一下方式从栈底（即数组头）开始遍历，其实是破坏了栈的封装性
        //但比依次弹出再倒序会快1ms
        for (Character c : stack) {
            ans.append(c);
        }
        return ans.toString();
    }
}
