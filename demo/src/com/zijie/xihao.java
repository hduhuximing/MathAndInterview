package com.zijie;

import java.util.*;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/11 4:34 下午
 * @description
 */


public class xihao {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] fav = new int[n];
        for (int i = 0; i < n; i++) {
            fav[i] = scan.nextInt();
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = fav[i];
            int value = i + 1;
            if (!map.containsKey(key)) {
                List<Integer> list = new LinkedList<>();
                list.add(value);
                map.put(key, list);
            } else {
                List<Integer> list = map.get(key);
                list.add(value);
            }
        }
        int m = scan.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            int lo = scan.nextInt();
            int hi = scan.nextInt();
            int des = scan.nextInt();
            List<Integer> list = map.get(des);
            int count = 0;
            if (list != null) {
                for (Integer integer : list) {
                    if (integer >= lo && integer <= hi) {
                        count++;
                    }
                }
            }
            queue.add(count);
        }
        for (Integer integer : queue) {
            System.out.println(integer);
        }

    }
}
