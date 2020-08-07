package offer;

import java.util.Scanner;

public class te {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        //美味
        int T = sc.nextInt();
        // 0 热量  1 美味
        int[][] mid = new int[N][2];
        int[][] last = new int[M][2];
        for (int i = 0; i < N; i++) {
            mid[i][0] = sc.nextInt();
            mid[i][1] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            last[i][0] = sc.nextInt();
            last[i][1] = sc.nextInt();
        }
        //最少
        int hot = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (mid[i][1] >= T && mid[i][0] < hot) {
                hot = mid[i][0];
            }
        }
        for (int i = 0; i < M; i++) {
            if (last[i][1] >= T && last[i][0] < hot) {
                hot = last[i][0];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //美味
                int currDe = mid[i][1] + last[j][1];
                if (currDe >= T) {
                    hot = Math.min(hot, mid[i][0] + last[j][0]);
                }
            }
        }
        if (hot == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(hot);
        }
    }
}
