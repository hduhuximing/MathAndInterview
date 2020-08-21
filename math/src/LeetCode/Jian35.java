package LeetCode;

import java.util.HashMap;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/19 4:39 下午
 * @description
 */
public class Jian35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node phead) {
        if (phead == null) {
            return null;
        }
        if (map.containsKey(phead)) {
            return map.get(phead);
        }
        Node node = new Node(phead.val);
        map.put(phead, node);
        node.next = copyRandomList(phead.next);
        node.random = copyRandomList(phead.random);
        return node;
    }
}
