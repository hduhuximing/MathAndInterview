package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 10:34 上午
 * @description
 */
public class Jian37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer str = new StringBuffer();
        return doSerialize(root, str).toString();
    }

    public StringBuffer doSerialize(TreeNode root, StringBuffer str) {
        if (root == null) {
            return str.append("null,");
        }
        str = str.append(root.val + ",");
        str = doSerialize(root.left, str);
        str = doSerialize(root.right, str);
        return str;
    }

    // Decodes your encoded data to tree.
    int index = -1;

    public TreeNode deserialize(String data) {
        String[] items = data.split(",");
        return helper(items);
    }

    public TreeNode helper(String[] items) {
        index++;
        //跳出条件
        if (index == items.length) {
            return null;
        }
        String s = items[index];
        if (s.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = helper(items);
        root.right = helper(items);
        return root;
    }
}
