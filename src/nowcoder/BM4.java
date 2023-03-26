package nowcoder;

import nowcoder.common.ListNode;

public class BM4 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode l1;
        ListNode l2;

        if (list1.val < list2.val) {
            l1 = list1;
            l2 = list2;
        } else {
            l1 = list2;
            l2 = list1;
        }
        ListNode res = l1;
        while (l1.next != null && l2 != null) {
            ListNode next;
            if (l1.next.val >= l2.val) {
                next = l2.next;
                l2.next = l1.next;
                l1.next = l2;
                l2 = next;
            } else {
                l1 = l1.next;
            }
        }
        if (l2 != null) {
            l1.next = l2;
        }
        return res;
    }
}
