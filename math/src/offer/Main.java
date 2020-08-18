package offer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.compress("aaaaa"));
    }

    public String compress(String s) {

        // write code here
        StringBuilder str = new StringBuilder();
        char last = s.charAt(0);
        int length = s.length();
        long count = 1;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == last) {
                count++;
            } else {
                str.append(last);
                str.append(count);
                last = s.charAt(i);
                count = 1;
            }
        }
        str.append(last).append(count);
        return str.toString().length() < s.length() ? str.toString() : s;
    }


    public int[][] convert(int[][] matrix) {
        if (matrix.length == 0) {
            return null;
        }
        // write code here
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < matrix.length; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < matrix[0].length; j++) {
                curr.add(matrix[i][j]);
            }
            stack.push(curr);
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = res.get(i).get(j);
            }
        }
        return matrix;
    }


    public int[] findAllCheapestPrice(int n, int[][] flights, int src) {
        // write code here
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dp[src][i] = 0;
        }
        //n个位置
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int[] flight : flights) {
                    if (dp[flight[0]][j - 1] != Integer.MAX_VALUE) {
                        dp[flight[1]][j] = Math.min(dp[flight[1]][j]
                                , dp[flight[0]][j - 1] + flight[2]);
                    }
                }
            }
            res[i] = dp[i][n - 1] == Integer.MAX_VALUE ? -1 : dp[i][n - 1];
        }
        return res;
    }
}
