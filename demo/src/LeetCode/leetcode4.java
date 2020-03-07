package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/6 11:07 上午
 * @description 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int sum = len1 + len2;
        //结果值
        int one = -1;
        int two = -1;
        //位置
        int aIndex = 0;
        int bIndex = 0;
        for (int i = 0; i <= sum / 2; i++) {
            one = two;
            if (aIndex < len1 && (bIndex >= len2
                    || nums1[aIndex] <= nums2[bIndex])) {
                two = nums1[aIndex++];
            } else {
                two = nums2[bIndex++];
            }
        }

        if ((sum & 1) == 0) {
            return (one + two) / 2.0;
        } else {
            return two;
        }
    }

    public static double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMax = m, iMin = 0;
        int mid = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMax + iMax) / 2;
            int j = mid - i;
            if (i < iMax && B[j - 1] > A[j]) {
                iMin++;
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax--;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
