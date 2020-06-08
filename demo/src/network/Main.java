package network;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Integer,Double> map=new HashMap<>();


        Set<Map.Entry<Integer, Double>> entries = map.entrySet();


  
    }
}
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
//
//import java.io.*;
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        StringBuilder str1 = new StringBuilder(str);
//        String s = str1.reverse().toString();
//        System.out.println(s);
//    }
//}