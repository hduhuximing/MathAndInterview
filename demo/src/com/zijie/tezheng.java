package com.zijie;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/11 7:19 下午
 * @description
 */
public class tezheng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max = -1;
        for (int i = 0; i < N; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            HashMap<String, Integer> temp = new HashMap<>();
            int M = sc.nextInt();
            //循环行
            for (int j = 0; j < M; j++) {
                //处理当前行
                int K = sc.nextInt();
                for (int k = 0; k < K; k++) {
                    int key = sc.nextInt();
                    int value = sc.nextInt();
                    String curr = key + "_" + value;
                    temp.put(curr, map.getOrDefault(curr, 0) + 1);
                    max = Math.max(max, temp.get(curr));
                }
                map.clear();
                map.putAll(temp);
            }
        }
        System.out.println(max);
    }
}
