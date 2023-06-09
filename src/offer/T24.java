package offer;

import common.ListNode;

public class T24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
