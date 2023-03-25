package easy;

import common.ListNode;

public class T83_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode now = head;
        while (now != null && now.next != null) {
            if (now.val != now.next.val) {
                now = now.next;
            } else {
                now.next = now.next.next;
            }
        }
        return head;
    }
}
