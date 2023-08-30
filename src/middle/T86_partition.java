package middle;

import common.ListNode;

/**
 * @author foanxi
 */
public class T86_partition {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode res = small;
        ListNode big = new ListNode(-1);
        ListNode bigHead = big;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val < x) {
                small.next = cur;
                small = small.next;
            } else {
                big.next = cur;
                big = big.next;
            }
            cur.next = null;
            cur = next;
        }
        small.next = bigHead.next;
        return res.next;
    }
}
