package LeetCode;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/23 4:38 下午
 * @description 给你一个由 '('、')' 和小写字母组成的字符串 s。
 * <p>
 * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 * <p>
 * 请返回任意一个合法字符串。
 * <p>
 * 有效「括号字符串」应当符合以下 任意一条 要求：
 * <p>
 * 空字符串或只包含小写字母的字符串
 * 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
 * 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "lee(t(c)o)de)"
 * 输出："lee(t(c)o)de"
 * 解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
 * 示例 2：
 * <p>
 * 输入：s = "a)b(c)d"
 * 输出："ab(c)d"
 * 示例 3：
 * <p>
 * 输入：s = "))(("
 * 输出：""
 * 解释：空字符串也是有效的
 * 示例 4：
 * <p>
 * 输入：s = "(a(b(c)d)"
 * 输出："a(b(c)d)"
 */
public class leetcode1249 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder str=new StringBuilder();
        boolean[] flag=new boolean[s.length()];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
                flag[i]=true;
            }else if(s.charAt(i)==')'){
                if(stack.isEmpty()){
                    flag[i]=true;
                }else{
                    flag[stack.pop()]=false;
                }
            }
        }
        for(int j=0;j<s.length();j++){
            if(!flag[j]){
                str.append(s.charAt(j));
            }
        }
        return str.toString();
    }
}
