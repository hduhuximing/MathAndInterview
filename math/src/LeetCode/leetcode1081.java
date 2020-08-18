package LeetCode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/17 7:10 下午
 * @description
 */
public class leetcode1081 {
    public String smallestSubsequence(String text) {
        Stack<Character> stack = new Stack<>();
        //记录每个字母最后出现的坐标
        HashMap<Character,Integer> lastOccur = new HashMap<>();
        //记录每个字母最后出现的坐标
        for (int i = 0; i < text.length(); i++) {
            lastOccur.put(text.charAt(i),i);
        }
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            //如果字母不在栈中
            if(!stack.contains(c)){
                //弹出比当前元素更大且在当前元素之后还会出现的字母
                //前两个条件保证当前元素比栈顶元素小，第三个条件保证栈顶元素在当前元素之后还会出现
                while (!stack.isEmpty() && stack.peek() > c && lastOccur.get(stack.peek()) > i) {
                    //从栈中弹出的同时，从记录栈的set中也移除
                    stack.pop();
                }
                //将当前元素加入栈和set
                stack.push(c);
            }
        }
        StringBuilder ans = new StringBuilder(stack.size());
        //因为Stack类是继承Vector,所以可以用一下方式从栈底（即数组头）开始遍历，其实是破坏了栈的封装性
        //但比依次弹出再倒序会快1ms
        for (Character c : stack) {
            ans.append(c.charValue());
        }
        return ans.toString();
    }
}
