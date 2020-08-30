package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/29 3:37 下午
 * @description
 */
public class leetcode645 {
    public int[] findErrorNums(int[] nums) {
        int[] counts = new int[nums.length + 1];
        for (int num : nums) {
            counts[num]++;
        }
        int[] res = new int[2];
        for (int i = 1; i <= nums.length; i++) {
            if (counts[i] == 0) {
                res[1] = i;
            } else if (counts[i] == 2) {
                res[0] = i;
            }
        }
        return res;
    }
}
