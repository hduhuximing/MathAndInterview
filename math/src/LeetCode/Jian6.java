package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/13 6:24 下午
 * @description
 */
public class Jian6 {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        ListNode temp = head;
        int index = 1;
        while (temp.next != null) {
            index++;
            temp = temp.next;
        }
        int[] arr = new int[index];
        while (head != null) {
            arr[--index] = head.val;
            head = head.next;
        }
        return arr;
    }

    public int[] reversePrint1(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        ListNode temp = head;
        int index = 1;
        while (temp.next != null) {
            temp = temp.next;
            index++;
        }
        int[] res = new int[index];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = head.val;
            head = head.next;
        }
        return res;
    }
}
