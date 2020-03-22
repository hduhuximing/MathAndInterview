package offer;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/20 8:54 上午
 * @description
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] list = new String[N];
        for (int i = 0; i < N; i++) {
            list[i] = sc.nextLine();
        }
        Arrays.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.charAt(0) == o2.charAt(0) ? o2.length()==o1.length()?
                        o1.compareTo(o2):o2.length()-o1.length() : o1.charAt(0) - o2.charAt(0);
            }
        });
        int max = 0;
        for (int i = 0; i <= N - 2; i++) {
            int curr = list[i].length();
            char start = list[i].charAt(curr - 1);
            for (int j = i + 1; j <= N - 1; j++) {
                if (list[j].charAt(0) > start) {
                    curr += list[j].length();
                    start = list[j].charAt(list[j].length()-1);
                }
                max = Math.max(curr, max);
            }
        }
        System.out.println(max);
    }
}


