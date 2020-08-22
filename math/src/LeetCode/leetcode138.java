package LeetCode;

import java.util.HashMap;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/22 12:46 下午
 * @description
 */
public class leetcode138 {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    ;
    HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        if (map.containsKey(head)) {
            return map.getOrDefault(head, null);
        }
        Node node = new Node(head.val, null, null);
        map.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }
}
