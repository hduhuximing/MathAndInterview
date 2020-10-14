package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/12 6:03 下午
 * @description
 */
public class leetcode437 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
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

    public int pathSum1(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSum1(root.left, sum) + pathSum1(root.right, sum) + help1(root, sum);
    }

    private int help1(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        int count = 0;
        if (sum == val) {
            count++;
        }
        int left = help1(root.left, sum - val);
        int right = help1(root.right, sum - val);
        return left + right + count;
    }
}
