package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/13 3:52 下午
 * @description
 */
public class leetcode494 {
    public static int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return help(nums, S, 0, 0, 0);
    }

    private static int help(int[] nums, int S, int count, int index, int sum) {
        if (index == nums.length) {
            if (S == sum) {
                count++;
            }
            return count;
        }
        return help(nums,S,count,index+1,sum-nums[index])
                +help(nums,S,count,index+1,sum+nums[index]);
    }

    public static void main(String[] args) {
        int targetSumWays = findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(targetSumWays);
    }
}
