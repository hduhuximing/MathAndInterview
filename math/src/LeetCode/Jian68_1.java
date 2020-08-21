package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 3:52 下午
 * @description
 */
public class Jian68_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root.val<p.val&&root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }else if(root.val>p.val&&root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }else{
            return root;
        }
    }
}
