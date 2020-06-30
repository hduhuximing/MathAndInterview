package com.meituan;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/27 10:51 下午
 * @description
 */
public class TrueOrFalse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String[] bools = line.trim().split(" ");
        if (bools.length == 0 || bools[0].equals("and") || bools[0].equals("or")) {
            System.out.println("error");
            return;
        }
        Stack<String> val = new Stack<>();
        Stack<String> op = new Stack<>();
        for (String s : bools) {
            if (s.equals("and") || s.equals("or")) {
                op.push(s);
            } else {
                if (!op.isEmpty() && op.peek().equals("and")) {
                    if (val.isEmpty()) {
                        System.out.println("error");
                        return;
                    }
                    String curr = val.pop();
                    op.pop();
                    if (curr.equals("false") || s.equals("false")) {
                        val.push("false");
                    } else {
                        val.push("true");
                    }
                } else {
                    val.push(s);
                }
            }
        }
        if (op.size() + 1 != val.size()) {
            System.out.println("error");
            return;
        }
        while (!val.isEmpty()) {
            if (val.pop().equals("true")){
                System.out.println("true");
                return;
            }
        }
        System.out.println("false");
    }
}

