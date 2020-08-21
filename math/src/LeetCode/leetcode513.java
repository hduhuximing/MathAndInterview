package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/19 1:29 下午
 * @description
 */
public class leetcode513 {
    int target = 0;
    int max = 0;

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        help(root, 0);
        target = root.val;
        return target;
//        int target = root.val;
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            TreeNode curr = queue.poll();
//            if (curr.right != null) {
//                queue.add(curr.right);
//                target = curr.right.val;
//            }
//            if (curr.left != null) {
//                queue.add(curr.left);
//                target = curr.left.val;
//            }
//        }
//        return target;

    }

    private void help(TreeNode root, int index) {
        if (root == null) {
            return;
        }
        if (max < index) {
            max = index;
            target = root.val;
        }
        help(root.left, index + 1);
        help(root.right, index + 1);
    }
}
