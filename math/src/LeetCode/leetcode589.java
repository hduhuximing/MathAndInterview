package LeetCode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/14 12:55 下午
 * @description
 */
public class leetcode589 {
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

    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            output.add(pop.val);
            Collections.reverse(pop.children);
            for (Node child : pop.children) {
                stack.push(child);
            }
        }
        return output;
    }
}
