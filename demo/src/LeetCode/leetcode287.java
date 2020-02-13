package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/12 11:33 上午
 * @description 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n^2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class leetcode287 {
    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 1;
        int j = nums.length;
        while (i < j) {
            int mid = i + (j - i) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int duplicate = findDuplicate(new int[]{1, 3, 2, 2, 5, 6});
        System.out.println(duplicate);
    }
}
