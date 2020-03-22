package com.zijie;

import java.util.Scanner;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/11 6:37 下午
 * @description
 */
public class tegong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        int[] dist = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = sc.nextInt();
        }
        sc.close();
        int mod = 99997867;
        long res = 0;
        int i = 0;
        int j = 2;
        while (j < N) {
            if (dist[j] - dist[i] > D) {
                i++;
            } else if (j - i < 2) {
                j++;
            } else {
                res += calC(j - i);
                j++;
            }
        }
        res = res % mod;
        System.out.println(res);
    }

    private static long calC(long num) {
        return num * (num - 1) / 2;
    }
}