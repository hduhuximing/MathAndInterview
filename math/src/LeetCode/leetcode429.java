package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/19 10:39 上午
 * @description
 */
public class leetcode429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        help(list, root, 0);
        return list;
    }

    private void help(List<List<Integer>> list, Node root, int index) {
        if (root == null) {
            return;
        }
        if (list.size() == index) {
            list.add(new ArrayList<>());
        }
        list.get(index).add(root.val);
        for (Node node : root.children) {
            help(list, node, index + 1);
        }
    }
}
