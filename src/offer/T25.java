package offer;

import common.ListNode;

public class T25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode dummyHead = new ListNode();
        ListNode pre = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                pre.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                pre.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            pre = pre.next;
        }
        while (l1!=null){
            pre.next = l1;
            l1 = l1.next;
        }
        while (l2!=null){
            pre.next = l2;
            l2=l2.next;
        }

        return dummyHead.next;
    }
}
