package nowcoder;

import nowcoder.common.ListNode;

public class BM10 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode h1 = pHead1;
        ListNode h2 = pHead2;
        while (h1 != h2){
            h1 = h1.next;
            h2 = h2.next;
            if (h1 == null && h2 == null){
                return null;
            }
            if (h1 == null){
                h1 = pHead2;
            }
            if (h2 == null){
                h2 = pHead1;
            }
        }
        return h1;
    }
}
