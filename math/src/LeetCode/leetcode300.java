package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/5 12:39 下午
 * @description 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 */
public class leetcode300 {
    public static void main(String[] args) {
        int [] arr={1,4,2,3,5};
        System.out.println(lengthOfLIS(arr));
    }

    public static int lengthOfLIS(int[] nums) {
        //判断是不是空
        //声明dp,当前位置最大的上升数
        //从头开始循环，每一个值初始值都是1
        //从头到当前位置前一位，看是不是比当前值小，小就更新dp[i]=Math.max(dp[i],dp[j]+1);
        //每次取max进行比较，得到最大的
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}