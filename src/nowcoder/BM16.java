package nowcoder;

import nowcoder.common.ListNode;

public class BM16 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummmyHead = new ListNode(-1);
        ListNode cur = head;
        dummmyHead.next = cur;
        ListNode pre = dummmyHead;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                ListNode next = cur.next;
                while (next != null && next.val == cur.val) {
                    next = next.next;
                }
                pre.next = next;
                cur = pre.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return dummmyHead.next;
    }
}
