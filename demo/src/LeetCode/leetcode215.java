package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/7 6:19 下午
 * @description 在未排序的数组中找到第 k 个最大的元素。请注意，
 * 你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        int target = len - k;
        while (true) {
            int index = help(nums, start, end);
            if (index < target) {
                start = index + 1;
            } else if (index > target) {
                end = index - 1;
            } else {
                return nums[index];
            }
        }

    }

    private int help(int[] nums, int start, int end) {
        if (start < end) {
            return -1;
        }
        int temp = nums[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && nums[i] <= temp) {
                i++;
            }
            nums[j] = nums[i];
            while (i < j && nums[j] >= temp) {
                j--;
            }
            nums[i] = nums[j];
        }
        nums[j] = temp;
        return j;
    }
}
