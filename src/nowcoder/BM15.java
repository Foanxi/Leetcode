package nowcoder;

import nowcoder.common.ListNode;

public class BM15 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            while (next != null && cur.val == next.val) {
                next = next.next;
            }
            cur.next = next;
            cur = cur.next;
        }
        return head;
    }
}
