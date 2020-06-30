package offer;
/**
 * 兼职动态规划问题
 * <p>
 * 问题描述：大学期间，小A想利用课余时间做一些网络兼职赚零花钱，于是小A通过网络收集到了兼职列表，
 * 并分析了每份兼职的时间耗费和报酬金额，在不超过课余时间的情况下，选定了一些工作从而
 * 达到最大报酬。
 * <p>
 * 输入（可以直接定义到代码中）：
 * 1. 兼职列表X个，每个兼职消耗的时间M（小时）
 * 2. 兼职列表X个，每个兼职获得的报酬N（元）
 * 3. 课余时间T（小时）
 * 假设不存在相同的时间消耗，也不存在相同的报酬
 * 输出：可以在T时间内完成，并获得最大报酬的总金额
 * <p>
 * 示例
 * 输入
 * 3 5 6 4
 * 5 6 5 7
 * 10
 * 输出
 * 13
 * <p>
 * 要求：
 * 1. 代码写出来
 * 2. 代码运行正确
 * 3. 运行结果正确
 */

import java.util.Scanner;

public class bag01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] times = sc.nextLine().split(" ");
        int len = times.length;
        int[] curtimes = new int[len];
        for (int i = 0; i < len; i++) {
            curtimes[i] = Integer.parseInt(times[i]);
        }
        int[] values = new int[len];
        for (int i = 0; i < len; i++) {
            values[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        //len个兼职,sum容量
        int[][] dp = new int[len + 1][sum + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum; j++) {
                //当前时间太大不选
                if (curtimes[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            dp[i - 1][j - curtimes[i - 1]] + values[i - 1]);
                }
            }
        }
        System.out.println(dp[len][sum]);
    }
}


//import java.util.*;
//    public class Main {
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            String[] times = sc.nextLine().split(" ");
//            int len = times.length;
//            int[] curtimes = new int[len];
//            for (int i = 0; i < len; i++) {
//                curtimes[i] = Integer.parseInt(times[i]);
//            }
//            int[] values = new int[len];
//            for (int i = 0; i < len; i++) {
//                values[i] = sc.nextInt();
//            }
//            int sum = sc.nextInt();
//            //len个兼职,sum容量
//            //处理第i件产品以及剩余量
//            System.out.println(help(len - 1, sum, curtimes, values));
//        }
//        //i第i个兼职，j剩余
//        public static int help(int i, int j, int[]curtimes, int[] values) {
//            //走到最前面，已经遍历完
//            if (i == -1) {
//                return 0;
//            }
//            int res = 0;
//            //当前剩余容量充足
//            if (j >= curtimes[i]) {
//                //模拟dp的比较
//                int res1 = help(i - 1, j - curtimes[i], curtimes, values) + values[i];
//                int res2 = help(i - 1,j, curtimes, values);
//                res = Math.max(res1, res2);
//            }
//            return res;
//        }
//    }

