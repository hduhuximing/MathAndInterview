package offer;

/**
 * @author ming
 * @version 1.0
 * @date 2020/4/12 4:23 下午
 * @description
 */

import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {

    public static void main(String args[]) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < n; i++) {
            int curr = sc.nextInt();
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        Set<Integer> set = map.keySet();
        for (int num : set) {
            map.put(num + 1, map.getOrDefault(num, 0) - 1);
            map.put(num - 1, map.getOrDefault(num, 0) - 1);

        }
        int sum = 0;
        for (int nums : set) {
            if (map.get(nums) > 0) {
                sum += nums;
            }
        }
        System.out.println(sum);
    }
}