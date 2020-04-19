package offer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });
        int count = 1;
        int start;
        int end;
        int currEnd = arr[0][1];
        for (int[] ls : arr) {
            start=ls[0];
            end=ls[1];
            if(currEnd<start){
                currEnd=end;
            }else{
                count++;
            }
        }
        System.out.println(count-1);
//        int end = arr[0][1];
//        int count = 1;
//        for (int i = 1; i < N; i++) {
//            while (i < N && end< arr[i][0]) {
//                end = arr[i][1];
//                count++;
//                i++;
//            }
//        }
//        System.out.println(N-count-1);
    }
}