package com.github;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/1/17 5:34 下午
 * @descirption github链表反转
 * https://github.com/0voice/interview_internal_reference/blob/master/01.%E9%98%BF%E9%87%8C%E7%AF%87/1.1.1%20%E5%A6%82%E4%BD%95%E5%AE%9E%E7%8E%B0%E4%B8%80%E4%B8%AA%E9%AB%98%E6%95%88%E7%9A%84%E5%8D%95%E5%90%91%E9%93%BE%E8%A1%A8%E9%80%86%E5%BA%8F%E8%BE%93%E5%87%BA%EF%BC%9F.md
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

}

public class ReverseNode {
    public void reverse(ListNode root) {
        if (root == null) {
            return;
        }
        ListNode pre = null;
        ListNode cur = root;
        ListNode after = root.next;
        while (after != null) {
            cur.next = pre;
            ListNode temp = after.next;
            after.next = cur;
            pre = cur;
            cur = after;
            after = temp;
        }
        //打印
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

//栈实现
    public void reverse1(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode currentNode = head;
        Stack<ListNode> stack = new Stack<>();
        while (currentNode != null) {
            stack.push(currentNode);
            ListNode tempNode = currentNode.next;
            currentNode.next = null; // 断开连接
            currentNode = tempNode;
        }

        head = stack.pop();
        currentNode = head;

        while (!stack.isEmpty()) {
            currentNode.next = stack.pop();
            currentNode = currentNode.next;
        }
    }
}
