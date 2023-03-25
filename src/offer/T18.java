package offer;

import common.ListNode;

public class T18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                break;
            }
            pre = head;
            head = head.next;
        }
        return dummyHead;
    }
}
