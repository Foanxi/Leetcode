package middle;

import common.ListNode;

public class T82_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        dummyHead.next = head;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode find = cur.next.next;
                while (find != null && find.val == cur.next.val) {
                    find = find.next;
                }
                cur.next = find;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
