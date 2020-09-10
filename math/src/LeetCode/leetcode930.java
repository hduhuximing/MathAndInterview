package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/6 3:08 下午
 * @description
 */
public class leetcode930 {
    public int numSubarraysWithSum(int[] A, int S) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (map.containsKey(sum - S)) {
                res += map.get(sum - S);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
