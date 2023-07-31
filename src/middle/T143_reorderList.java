package middle;

import common.ListNode;

/**
 * @author hujinxu
 */
public class T143_reorderList {
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (slow == null) {
            return;
        }
        // slow即为中间结点
        ListNode p = slow.next;
        slow.next = null;
        ListNode p1 = head;
        ListNode p2 = reverse(p);
        while (p2 != null) {
            ListNode next = p1.next;
            p1.next = p2;
            ListNode next2 = p2.next;
            p2.next = next;
            p1 = next;
            p2 = next2;
        }
    }

    public ListNode reverse(ListNode cur) {
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
