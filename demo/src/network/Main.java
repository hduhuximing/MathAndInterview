package network;


import java.util.Scanner;

/**
 * @author ming
 * @version 1.0
 * @date 2020/4/10 11:11 下午
 * @description
 */
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for (int i = 0; i < T; i++) {
//            //N个桶
//            int N = sc.nextInt();
//            //操作数
//            int M = sc.nextInt();
//            Map<Integer, Set<Integer>> map = new HashMap<>();
//            for (int j = 1; j <= N; j++) {
//                HashSet<Integer> set = new HashSet<>();
//                set.add(j);
//                map.put(j, set);
//            }
//            for (int j = 0; j < M; j++) {
//                int op = sc.nextInt();
//                if (op == 1) {
//                    int X = sc.nextInt();
//                    int Y = sc.nextInt();
//                    Set<Integer> set1 = map.get(X);
//                    Set<Integer> set2 = map.get(Y);
//                    set1.addAll(set2);
//                    set2.addAll(set1);
//                    for (Integer curr : set1) {
//                        if (curr != X && curr != Y) {
//                            Set<Integer> integers = map.get(curr);
//                            integers.addAll(set1);
//                        }
//                    }
//                } else if (op == 2) {
//                    //其他桶删除当前的X
//                    int X = sc.nextInt();
//                    Set<Integer> set = map.get(X);
//                    for (Integer curr : set) {
//                        if (curr != X) {
//                            map.get(curr).remove(X);
//                        }
//                    }
//                    //原来的桶变为只有一个元素
//                    Set<Integer> set1 = new HashSet<>();
//                    set1.add(X);
//                    map.put(X, set1);
//                } else if (op == 3) {
//                    int X = sc.nextInt();
//                    System.out.println(map.get(X).size());
//                }
//            }
//        }
//    }
//}
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        for (int i = 0; i < N; i++) {
//            int po = sc.nextInt();
//            int[][] arr = new int[po][po];
//            int len = sc.nextInt();
//            for (int j = 0; j < po; j++) {
//                for (int k = 0; k < po; k++) {
//                    arr[j][k] = sc.nextInt();
//                }
//            }
//            int X = sc.nextInt();
//            int Y = sc.nextInt();
//            Map<Integer, Integer> map = new TreeMap<>();
//            for (int j = 0; j < po; j++) {
//                for (int k = 0; k < po; k++) {
//                    if (arr[j][k] != 0) {
//                        int key = (X - j) * (X - j) + (Y - k) * (Y - k);
//                        int value = arr[j][k];
//                        map.put(key, map.getOrDefault(key, 0) + value);
//                    }
//                }
//            }
//            for(Map.Entry<Integer,Integer>entry:map.entrySet()){
//                if(len*len<entry.getKey()){
//                    break;
//                }else{
//                    len+=entry.getValue();
//
//                }
//            }
//            System.out.println(len);
//        }
//    }
//}

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder str1 = new StringBuilder(str);
        String s = str1.reverse().toString();
        System.out.println(s);
    }
}