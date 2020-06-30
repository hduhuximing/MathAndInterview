package LeetCode;

import java.util.Arrays;

/**
 * @author ming
 * @version 1.0
 * @date 2020/4/3 9:02 下午
 * @description
 */
public class JIanleetcode45 {
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder strs = new StringBuilder();
        for (String curr : str) {
            strs.append(curr);
        }
        return strs.toString();
    }
}
