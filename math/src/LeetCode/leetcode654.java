package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/12 10:07 上午
 * @description
 */
public class leetcode654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return help(nums, 0, nums.length);
    }

    private TreeNode help(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int max = maxNode(nums, start, end);
        TreeNode root = new TreeNode(nums[max]);
        root.left = help(nums, start, max);
        root.right = help(nums, max + 1, end);
        return root;
    }

    private int maxNode(int[] nums, int start, int end) {
        int max_i = start;
        for (int i = start; i < end; i++) {
            if (nums[i] > nums[max_i]) {
                max_i = i;
            }
        }
        return max_i;
    }
}
