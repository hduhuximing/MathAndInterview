package offer;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/5 4:49 下午
 * @description 一个整数数组, 将这个数组划分为一些连续的子数组,
 * 将各个子数组内部元素进行排序后，整个数组是有序的，问最多能切成多少个子数组
 */
public class ArrCut {


    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3, 6, 5};
        ArrCut cut = new ArrCut();
        int i = cut.partitionArray(nums);
        System.out.println(i);
    }

    public int partitionArray(int[] nums) {
        int res = 0;
        int n = nums.length;
        // maxLeft[k] [0,k]之间的nums最大值
        int[] maxLeft = new int[n];
        // minRight[k] [k, n-1]的nums最小值
        int[] minRight = new int[n];
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = Math.max(max, nums[i]);
            }
            maxLeft[i] = max;
        }
        int min = nums[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < min) {
                min = Math.min(min, nums[i]);
            }
            minRight[i] = min;
        }
        for (int i = 0; i < n - 1; i++) {
            // 当左边最大值 <= 右边最小值  时可以进行切分
            if (maxLeft[i] <= minRight[i + 1]) {
                int j = i + 1;
                System.out.println(i + " - " + j);

                res++;
            }
        }
        return res;
    }

}
