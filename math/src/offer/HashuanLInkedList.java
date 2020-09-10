package offer;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/6 4:13 下午
 * @description 如何判断两个有环链表是否相交
 * https://blog.csdn.net/computer_user/article/details/86836186
 */
public class HashuanLInkedList {
    class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }
    //loop1和loop2 是入环点，区分入环点是否相同
    public Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

}
