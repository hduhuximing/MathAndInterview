package LeetCode;

import java.util.HashMap;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/22 2:59 下午
 * @description
 */
public class leetcode1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        HashMap<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        head=dumy;
        //求前缀和，后面的和覆盖前面的和
        while (head != null) {
            sum += head.val;
            map.put(sum, head);
            head = head.next;
        }
        sum = 0;
        head = dumy;
        while (head != null) {
            sum += head.val;
            ListNode node = map.get(sum);
            //当前节点的下一个节点为跳过中间和为0的节点
            head.next = node.next;
            head = head.next;
        }
        return dumy.next;
    }
}
