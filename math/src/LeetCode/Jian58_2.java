package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 3:17 下午
 * @description
 */
public class Jian58_2 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder str=new StringBuilder();
        str.append(s).append(s);
        return str.substring(n,n+s.length());//包头不包尾
    }
}
