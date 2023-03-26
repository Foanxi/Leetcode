package nowcoder;

import nowcoder.common.ListNode;

public class BM7 {

    /**
     * 使用快慢指针法查找环
     *
     * @param pHead 链表头节点
     * @return 环的入口
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        // 快指针每次走两步，慢指针每次走一步
        // 当快慢指针相遇的时候，快指针走了2(X+Y)，慢指针走了(X+Y)
        // 此时慢指针距离入口节点还是X的距离，头节点距离入口节点也是X的距离
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        // 如果为空则直接返回空，说明不存在环
        if (fast == null || fast.next == null) {
            return null;
        }

        fast = pHead;
        // 同步走相同距离，再次相遇的时候即入口节点
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
