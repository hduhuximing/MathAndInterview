package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/1 8:43 下午
 * @description
 */
public class leetcode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            nums1[i + j + 1] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[i + j + 1] = nums2[j--];
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i < 0 || nums2[j] >= nums1[i]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
    }
}
