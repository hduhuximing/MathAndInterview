package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/7 11:16 上午
 * @description 我们希望下一个数比当前数大，这样才满足“下一个排列”的定义。因此只需要将后面的大数与前面的小数交换，
 * 就能得到一个更大的数。比如 123456，将 5 和 6 交换就能得到一个更大的数 123465。
 * 我们还希望下一个数增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：
 * 在尽可能靠右的低位进行交换，需要从后向前查找
 * 将一个尽可能小的大数与前面的小数交换。比如 123465，下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
 * 将大数换到前面后，需要将大数后面的所有数重置为升序，升序排列就是最小的排列。以 123465 为例：首先按照上一步，
 * 交换 5 和 4，得到 123564；然后需要将 5 之后的数重置为升序，得到 123546。显然 123546 比 123564 更小，
 * 123546 就是 123465 的下一个排列
 */
public class leetcode31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        revers(nums, i + 1);
    }

    private void revers(int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
