package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/27 10:02 下午
 * @description
 */
public class leetcode133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node root = new Node(node.val, new ArrayList<>());
        map.put(node, root);
        for (Node neighbor : node.neighbors) {
            node.neighbors.add(cloneGraph(neighbor));
        }
        return root;
    }
}