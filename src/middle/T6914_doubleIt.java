package middle;

import common.ListNode;

/**
 * @author foanxi
 */
public class T6914_doubleIt {

    int next = 0;

    public ListNode doubleIt(ListNode head) {
        ListNode temp = traversal(head);
        ListNode dummyHead = new ListNode(-1);
        if (next != 0) {
            ListNode listNode = new ListNode(next);
            dummyHead.next = listNode;
            listNode.next = temp;
            return dummyHead.next;
        } else {
            return temp;
        }
    }

    public ListNode traversal(ListNode head) {
        if (head == null) {
            return null;
        }
        head.next = traversal(head.next);
        int num = head.val * 2 + next;
        if (num >= 10) {
            next = num / 10;
        } else {
            next = 0;
        }
        head.val = num % 10;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
//        ListNode l2 = new ListNode(8);
//        ListNode l3 = new ListNode(9);
//        l1.next = l2;
//        l2.next = l3;
        new T6914_doubleIt().doubleIt(l1);
    }
}
