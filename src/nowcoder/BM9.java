package nowcoder;

import nowcoder.common.ListNode;

public class BM9 {
    /**
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }
        ListNode fast = head;
        for (int i = 0; i <= n; ++i) {
            fast = fast.next;
        }
        ListNode slow = head;
        if (fast == null) {
            return slow.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
