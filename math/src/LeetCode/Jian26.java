package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/19 3:38 下午
 * @description
 */
public class Jian26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //先找初始位置，就是不为空的位置
        if (A != null && B != null) {
            return isEquals(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        } else {
            return false;
        }
    }

    public boolean isEquals(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null || (root1.val != root2.val)) {
            return false;
        }
        return isEquals(root1.left, root2.left) && isEquals(root1.right, root2.right);
    }
}
