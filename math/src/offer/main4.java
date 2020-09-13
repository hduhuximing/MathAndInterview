package offer;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String man = sc.nextLine();
        String girl = sc.nextLine();
        String[] boys = man.split(" ");
        String[] girls = girl.split(" ");
        int n = sc.nextInt();
        int[][] ids = new int[n][2];
        for (int i = 0; i < n; i++) {
            ids[i][0] = sc.nextInt();
            ids[i][1] = sc.nextInt();
        }
        peidui(boys, girls, ids);
    }

    private static int max = 0;

    private static void peidui(String[] boys, String[] girls, int[][] ids) {
        Set<Integer> boy = new HashSet<>();
        Set<Integer> girl = new HashSet<>();

        int n = ids.length;

        for (int i = 0; i < boys.length; i++) {
            int a = Integer.valueOf(boys[i]);
            boy.add(a);
        }
        for (int i = 0; i < girls.length; i++) {
            int b = Integer.valueOf(girls[i]);
            girl.add(b);
        }
        dfs(boy, girl, 0, ids, 0, n);
        System.out.println(max);

    }

    private static void dfs(Set<Integer> boy, Set<Integer> girl, int result, int[][] ids, int point, int n) {
        if (point == n) {
            max = Math.max(max, result);
            return;
        }
        int startPoint = point;
        int endPoint = point + 1;

        while (ids[endPoint][0] == ids[startPoint][0]) {
            endPoint++;
            if (endPoint == n) {
                break;
            }
        }

        int temp = endPoint - startPoint;
        for (int i = startPoint; i < endPoint; i++) {
            if (boy.contains(ids[i][0]) && girl.contains(ids[i][1]) && i < n) {
                boy.remove(ids[i][0]);
                girl.remove(ids[i][1]);
                max = Math.max(max, result + 1);
                dfs(boy, girl, result + 1, ids, endPoint, n);
                boy.add(ids[i][0]);
                girl.add(ids[i][1]);
            }
        }

    }
}