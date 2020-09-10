package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/7 1:11 下午
 * @description
 */
public class leetcode17_05 {
    public String[] findLongestSubarray(String[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int preSum = 0;
        map.put(0, -1);
        for (int i = 0; i < array.length; i++) {
            preSum += Character.isDigit(array[i].charAt(0)) ? 1 : -1;
            if (!map.containsKey(preSum)) {
                map.put(preSum, i);
            } else {
                int pre = map.get(preSum);
                if (i - pre > end - start) {
                    end = i;
                    start = pre;
                }
            }

        }
        return Arrays.copyOfRange(array, start + 1, end + 1);
    }

    public static void main(String[] args) {
        String A=new String("abd");
        String B=new String("abd");
        String C="abd";
        System.out.println(A.equals(B));
    }
}
