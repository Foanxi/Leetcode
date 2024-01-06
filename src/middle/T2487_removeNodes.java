package middle;

import common.ListNode;

import java.util.ArrayDeque;

public class T2487_removeNodes {
    public ListNode removeNodes(ListNode head) {
        ArrayDeque<ListNode> deque = new ArrayDeque<>();
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            while (!deque.isEmpty() && deque.peekLast().val < cur.val) {
                deque.pollLast();
            }
            deque.addLast(cur);
            cur.next = null;
            cur = next;
        }
        cur = deque.pollFirst();
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = cur;
        while (!deque.isEmpty()) {
            cur.next = deque.pollFirst();
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
