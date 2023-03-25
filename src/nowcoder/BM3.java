package nowcoder;


import nowcoder.common.ListNode;

/**
 * @author foanxi
 */
public class BM3 {
    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        for (int i = 0; i < k; ++i) {
            if (tail == null){
                return head;
            }
            tail = tail.next;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != tail){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = reverseKGroup(tail,k);
        return pre;
    }
}
