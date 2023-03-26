package nowcoder;

import nowcoder.common.ListNode;

public class BM6 {
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null){
            if (fast.next == null){
                return false;
            }else {
                fast = fast.next.next;
            }
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
