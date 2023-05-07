package nowcoder;

import nowcoder.common.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author foanxi
 */
public class BM14 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public ListNode oddEvenList2(ListNode head) {
        Queue<ListNode> oddQueue = new LinkedList<>();
        Queue<ListNode> evenQueue = new LinkedList<>();
        int i = 1;
        while (head != null) {
            if (i % 2 == 1) {
                oddQueue.add(head);
            } else {
                evenQueue.add(head);
            }
            head = head.next;
            i++;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (!oddQueue.isEmpty()) {
            cur.next = oddQueue.poll();
            cur = cur.next;
        }
        while (!evenQueue.isEmpty()) {
            cur.next = evenQueue.poll();
            cur = cur.next;
        }
        cur.next = null;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        new BM14().oddEvenList(listNode1);
    }
}
