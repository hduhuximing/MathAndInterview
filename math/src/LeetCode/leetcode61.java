package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/1 8:13 下午
 * @description
 */
public class leetcode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode res=head;
        int len=1;
        while(res.next!=null){
            res=res.next;
            len++;
        }
        res.next=head;
        for (int i = 1; i <len-k%len ; i++) {
            head=head.next;
        }

        ListNode first=head.next;
        head.next=null;
        return first;
    }
}
