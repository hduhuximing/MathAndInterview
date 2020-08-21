package LeetCode;

import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/19 3:02 下午
 * @description
 */
public class leetcode559 {
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

    public int maxDepth(Node root) {
        int max = 0;
        if (root == null) {
            return max;
        }
        List<Node> children = root.children;
        for (int i = 0; i < children.size(); i++) {
            max = Math.max(max, maxDepth(children.get(i)));
        }
        return max + 1;
    }
}
