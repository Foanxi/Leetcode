package middle;

import common.ListNode;

public class T24_swapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            temp.next = temp.next.next;
            cur.next = temp;
            cur = cur.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        new T24_swapPairs().swapPairs(p1);
    }
}
