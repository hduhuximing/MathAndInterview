package offer;

import java.util.Scanner;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/31 3:10 下午
 * @description
 */
public class te1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String curr = sc.next();
        curr.trim();
        if ("".equals(curr)) {
            return;
        }
        int i = 0;
        int re = 1;
        long res = 0;
        if (curr.charAt(i) == '-') {
            re = -1;
        }
//        StringBuilder str = new StringBuilder();
        for (; i < curr.length(); i++) {
            if (curr.charAt(i) >= '0' && curr.charAt(i) <= '9') {
                res = res * 10 + curr.charAt(i) - '0';
//                str.append(curr.charAt(i));
            }
        }
        if(res*re<Integer.MIN_VALUE||res*re>Integer.MAX_VALUE){
            return;
        }
        System.out.println(res);
    }
}
