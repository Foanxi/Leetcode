package offer;

import common.ListNode;

public class T22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode right = head;
        while (k >= 0) {
            right = right.next;
            k--;
        }

        while (right != null) {
            head = head.next;
            right = right.next;
        }
        return head;
    }
}
