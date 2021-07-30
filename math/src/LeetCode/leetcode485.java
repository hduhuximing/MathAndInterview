package LeetCode;

public class leetcode485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 1) {
                len++;
            } else {
                max = Math.max(max, len);
                len = 0;
            }
        }
        return Math.max(max, len);
    }
}
