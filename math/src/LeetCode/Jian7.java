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
        if (preorder == null || inorder == null) {
            return null;
        }
        //存中序
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, map);
    }

    public TreeNode recTree(int[] pre, int startPre, int endPre,
                            int[] inorder, int startIn, int endIn, HashMap<Integer, Integer> map) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        //先序是根
        TreeNode root = new TreeNode(pre[startPre]);
        //根节点在中序中的位置
        int index = map.get(pre[startPre]);
        root.left = recTree(pre, startPre + 1, startPre + index - startIn,
                inorder, startIn, index - 1, map);
        root.right = recTree(pre, startPre + index - startIn + 1, endPre,
                inorder, index + 1, endIn, map);
        return root;
    }
}
