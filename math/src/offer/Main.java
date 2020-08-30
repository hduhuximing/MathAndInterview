package offer;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ans = best(s);
        System.out.println(ans);
    }

    public static String best(String s) {
        int k = 0;
        //找到第一个不是_的位置
        for (; k < s.length(); k++) {
            if (s.charAt(k) != '_') {
                break;
            }
        }

        StringBuilder str = new StringBuilder();
        str.append(s.charAt(k));
        char pre = s.charAt(k);
        k++;
        for (; k < s.length(); k++) {
            if (s.charAt(k) == '_' && pre == '_') {
                continue;
            }
            str.append(s.charAt(k));
            pre = s.charAt(k);
        }
        if (str.charAt(str.length() - 1) == '_') {
            return str.substring(0, str.length() - 1);
        } else {
            return str.toString();
        }
    }

}