package nowcoder;

import nowcoder.common.ListNode;

import java.util.ArrayList;

public class BM5 {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0){
            return null;
        }
        return mergeBin(lists, 0, lists.size());
    }

    public ListNode mergeBin(ArrayList<ListNode> list, int start, int end) {
        if (end - start <= 1) {
            return merge(list.get(start), list.get(end - 1));
        }
        int mid = (end - start) / 2 + start;
        ListNode left = mergeBin(list, start, mid);
        ListNode right = mergeBin(list, mid, end);
        return merge(left, right);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        if (list1 == list2) {
            return list1;
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
