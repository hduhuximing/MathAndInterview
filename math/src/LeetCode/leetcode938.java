package LeetCode;

public class leetcode938 {
    int ans;

    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        dfs(root, L, R);
        return ans;
    }

    private void dfs(TreeNode root, int l, int r) {
        if (root == null) {
            return;
        }
        if (root.val > l && root.val < r) {
            ans += root.val;
        }
        dfs(root.left, l, r);
        dfs(root.right, l, r);
    }
}
