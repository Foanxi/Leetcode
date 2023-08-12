package hard;

import common.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

public class T23_mergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeBinList(lists, 0, lists.length - 1);
    }

    public ListNode mergeBinList(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return lists[left];
        }
        int mid = (right - left) / 2 + left;
        ListNode leftNode = mergeBinList(lists, left, mid);
        ListNode rightNode = mergeBinList(lists, mid + 1, right);
        return mergeList(leftNode, rightNode);
    }

    public ListNode mergeList(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        if (l1.val >= l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode dummyHead = l1.val >= l2.val ? l2 : l1;
        while (l1.next != null && l2 != null) {
            if (l1.next.val >= l2.val) {
                ListNode next = l2.next;
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
        return dummyHead;
    }

    public ListNode mergeList2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode cur : lists) {
            while (cur != null) {
                ListNode temp = cur.next;
                queue.add(cur);
                cur.next = null;
                cur = temp;
            }
        }
        ListNode head = queue.poll();
        ListNode cur = head;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
