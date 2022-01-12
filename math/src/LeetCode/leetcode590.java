package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2022/1/3 5:22 PM
 * @description
 */


public class leetcode590 {
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

    ;
    List<Integer> list;

    public List<Integer> postorder(Node root) {
        list = new ArrayList<>();
        order(root);
        return list;
    }

    public void order(Node root) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            order(root.children.get(i));
        }
        list.add(root.val);
    }
}
