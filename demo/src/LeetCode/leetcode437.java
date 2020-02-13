package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/12 6:03 下午
 * @description
 */
public class leetcode437 {
    public static int pathSum(TreeNode root, int sum) {
        return help(root, sum, new int[1000], 0);
    }

    private static int help(TreeNode root, int sum, int[] array, int p) {
        if (root == null) {
            return 0;
        }
        //判断当前的数据是不是相等
        int temp = root.val;
        int n = 0;
        if (temp == sum) {
            n++;
        }
        //判断当前之前的路径上是不是有和是相等的
        for (int i = p - 1; i >= 0; i--) {
            temp += array[i];
            if (temp == sum) {
                n++;
            }
        }

        array[p] = root.val;
        int left = help(root.left, sum, array, p + 1);
        int right = help(root.right, sum, array, p + 1);
        return n + left + right;
    }

}
