package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/22 7:14 下午
 * @description
 */
public class leetcode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int inLen = inorder.length;
        int preLen = preorder.length;
        if (inLen != preLen || inLen == 0) {
            return null;
        } else if (preLen == 1) {
            return new TreeNode(inorder[0]);
        }
        return recTree(preorder, 0, preLen, inorder, 0, inLen);
    }

    public TreeNode recTree(int[] pre, int startPre, int endPre,
                            int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        //前序首位置作为根节点，是中序的分割点
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = recTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = recTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }
}
