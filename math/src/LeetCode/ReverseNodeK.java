package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/13 1:34 下午
 * @description
 */
public class ReverseNodeK {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        //作为返回值
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //每次判断都指向前反转完的末尾，内部作为移动指针
        ListNode pointer = dummy;
        while (pointer != null) {
            // 记录上一个子链表的尾，因为pointer是要移动的指针
            ListNode lastGroup = pointer;
            int i = 0;
            for (; i < k; ++i) {
                pointer = pointer.next;
                if (pointer == null) {
                    break;
                }
            }
            // 如果当前子链表的节点数满足 k, 就进行反转，此时pointer指向反转的最后一个节点
            // 反之，说明程序到尾了，节点数不够，不用反转
            if (i == k) {
                // 记录下一个子链表的头
                ListNode nextGroup = pointer.next;

                // 反转当前子链表，reverse 函数返回反转后子链表的头
                ListNode reversedList = reverse(lastGroup.next, nextGroup);

                // lastGroup 是上一个子链表的尾，其 next 指向当前反转子链表的头
                // 但是因为当前链表已经被反转，所以它指向的是反转后的链表的尾
                pointer = lastGroup.next;

                // 将上一个链表的尾连向反转后链表的头
                lastGroup.next = reversedList;

                // 当前反转后的链表的尾连向下一个子链表的头
                pointer.next = nextGroup;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null, next = null;
        while ((head != null) && (head != tail)) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
