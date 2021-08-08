package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/17 2:01 下午
 * @description
 */
public class Jian27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//        if (root.left != null) {
//            mirrorTree(root.left);
//        }
//        if (root.right != null) {
//            mirrorTree(root.right);
//        }
//        return root;


        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
