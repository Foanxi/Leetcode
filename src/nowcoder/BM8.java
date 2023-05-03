package nowcoder;

import nowcoder.common.ListNode;

/**
 * @author foanxi
 */
public class BM8 {
    /**
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        ListNode fast = pHead;
        for (int i = 0; i < k; ++i) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        ListNode slow = pHead;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
