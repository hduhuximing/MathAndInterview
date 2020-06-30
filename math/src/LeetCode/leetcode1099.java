package LeetCode;

import java.util.Arrays;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/12 1:27 下午
 * @description 给你一个整数数组 A 和一个整数 K，请在该数组中找出两个元素，使它们的和小于 K 但尽可能地接近 K，返回这两个元素的和。
 * <p>
 * 如不存在这样的两个元素，请返回 -1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [34,23,1,24,75,33,54,8], K = 60
 * 输出：58
 * 解释：
 * 34 和 24 相加得到 58，58 小于 60，满足题意。
 * 示例 2：
 * <p>
 * 输入：A = [10,20,30], K = 15
 * 输出：-1
 * 解释：
 * 我们无法找到和小于 15 的两个元素。
 */
public class leetcode1099 {
    public static int twoSumLessThanK(int[] A, int K) {
        if (A == null || A.length == 0) {
            return -1;
        }
        Arrays.sort(A);
        int res = Integer.MIN_VALUE;
        int i = 0, j = A.length-1;
        while (i < j) {
            int cur=A[i]+A[j];
            if(cur>=K){
                j--;
            }else{
                res=Math.max(res,A[i]+A[j]);
                i++;
            }
        }
        return res == Integer.MIN_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int i = twoSumLessThanK(new int[]{34, 23, 1, 24, 75, 33, 54, 8}, 60);
        System.out.println(i);
    }
}
