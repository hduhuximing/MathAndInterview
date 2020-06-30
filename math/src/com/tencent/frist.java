package com.tencent;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/1/29 4:46 下午
 * @descirption 时间限制：C/C++ 2秒，其他语言4秒
 * <p>
 * 空间限制：C/C++ 256M，其他语言512M
 * <p>
 * 小Q想要给他的朋友发送一个神秘字符串，但是他发现字符串的过于长了，
 * 于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，
 * 对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，
 * 例如字符串ABCABCABC将会被压缩为[3|ABC]，现在小Q的同学收到了小Q发送过来的字符串，你能帮助他进行解压缩么？
 * <p>
 * <p>
 * 输入描述:
 * 输入第一行包含一个字符串s，代表压缩后的字符串。
 * S的长度<=1000;
 * S仅包含大写字母、[、]、|;
 * 解压后的字符串长度不超过100000;
 * 压缩递归层数不超过10层;
 * <p>
 * 输出描述:
 * 输出一个字符串，代表解压后的字符串。
 * <p>
 * 输入例子1:
 * HG[3|B[2|CA]]F
 * <p>
 * 输出例子1:
 * HGBCACABCACABCACAF
 */
public class frist {

    /**
     * 这里要想到，栈中存储的只是当前需要右括号变化的，没括号的，前面可以直接添加到结果中
     * 在栈中必然栈底部是左括号，只有遇到右括号的时候才进入判断，如果不是右括号吗，那么直接加入到栈中，因为此时还是在整体括号内部。
     * @param args
     */
    public static void main(String[] args) {
        //输入
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        //返回
        StringBuffer str = new StringBuffer();
        //用栈作为缓存
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 'A' || c > 'Z' || !stack.isEmpty()) {
                if (c == ']') {
                    //拼接当前需要重复的字符串
                    char cur = stack.pop();
                    String curStr = "";
                    while (cur != '|') {
                        curStr += cur;
                        cur = stack.pop();
                    }
                    curStr = reverse(curStr);

                    //获取重复的数值
                    cur = stack.pop();
                    String curCount = "";
                    while (cur != '[') {
                        curCount += cur;
                        cur = stack.pop();
                    }
                    curCount = reverse(curCount);
                    int count = Integer.parseInt(curCount);

                    //根据数量拼接
                    String curRes = "";
                    for (int k = 0; k < count; k++) {
                        curRes += curStr;
                    }

                    //这里如果栈是空的表示当前不同向前找带括号的了
                    if (stack.isEmpty()) {
                        str.append(curRes);
                    } else {

                        for (int j = 0; j < curRes.length(); j++) {
                            char ct = curRes.charAt(j);
                            stack.push(ct);
                        }
                    }
                } else {
                    stack.push(c);
                }
            } else {
                str.append(c);
            }
        }
        System.out.println(str.toString());
    }

    private static String reverse(String str) {
        if (str.length() <= 1)
            return str;
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();
    }
}

