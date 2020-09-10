package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/4 10:24 上午
 * @description
 */
public class leetcode1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int res = 0;
        while (right < nums.length) {
            if ((nums[right++] & 1) == 1) {
                count++;
            }
            if (count == k) {
                int ri = 0;
                while (right < nums.length && (nums[right] & 1) == 0) {
                    right++;
                    ri++;
                }
                int le = 0;
                while ((nums[left] & 1) == 0) {
                    le++;
                    left++;
                }
                //左侧的偶数数量+1 *右侧偶数数量+1
                res += (le + 1) * (ri + 1);
                left++;
                count--;
            }
        }
        return res;
    }
}
