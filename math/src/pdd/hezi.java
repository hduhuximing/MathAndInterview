package pdd;

import java.util.Scanner;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/13 5:25 下午
 * @description https://www.nowcoder.com/questionTerminal/4efe0a1953114c4ea5cdec4cddbbfa88?f=discussion
 */
public class hezi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(cal(n));
    }

    private static int cal(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return 1 + cal(n / 2);
        }
    }
}
