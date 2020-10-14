package offer;

import java.util.Scanner;

public class main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int[] arr = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        int res = help(arr);
        if (res == -1) {
            System.out.println(-1);
        } else {
            System.out.println(res * 4);
        }
    }

    public static int help(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int avg = sum / 4;
        int sub = 0;
        for (int i = avg; i >= 0; i--) {
            for (int item : arr) {
                if (item > i) {
                    sub += item - i;
                }
            }
            int count = 0;
            for (int item : arr) {
                if (item < i) {
                    count += (i - item) * 2;
                }
            }
            if (count == sub) {
                return i;
            }
        }
        return -1;
    }
}


