package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/12 8:13 下午
 * @description
 */
public class leetcode538 {
//    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null){
            return null;
        }
        help(root,0);
        return root;
    }

    private int help(TreeNode root,int sum) {
        if (root == null) {
            return sum;
        }
        sum= help(root.right,sum);
        root.val+=sum;
        sum=root.val;
        sum=help(root.left,sum);
        return sum;
    }
}
