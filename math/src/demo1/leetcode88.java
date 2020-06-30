package demo1;

public class leetcode88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int[] merge = leetcode88.merge(nums1, 3, nums2, 3);
        for (int i : merge) {
            System.out.println(i);
        }
    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        //1
        // System.arraycopy(nums2,0,nums1,m,n);
        // Arrays.sort(nums1);
        //2
        // int[] nums1copy=new int[m];
        // System.arraycopy(nums1,0,nums1copy,0,m);
        // int p1=0;
        // int p2=0;
        // int p3=0;
        // while((p1<m)&&(p2<n)){
        //     nums1[p3++]=(nums1copy[p1]>nums2[p2]?nums2[p2++]:nums1copy[p1++]);
        // }
        // if(p1<m){
        //     System.arraycopy(nums1copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        // }
        // if (p2 < n)
        //     System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        //3
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        return nums1;
    }
}
