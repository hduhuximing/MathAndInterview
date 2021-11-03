package LeetCode;

import java.util.HashMap;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/13 6:28 下午
 * @description
 */
public class Jian7 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }

    public TreeNode recTree(int[] pre, int startPre, int endPre, int startIn, int endIn, HashMap<Integer, Integer> map) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        int index = map.get(root.val);
        root.left = recTree(pre, startPre + 1, index - startIn + startPre, startIn, index - 1, map);
        root.right = recTree(pre, index - startIn + startPre + 1, endPre, index + 1, endIn, map);
        return root;
    }
}
