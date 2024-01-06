package middle;

import common.ListNode;

public class T2807_insertGreatestCommonDivisors {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while (cur.next != null) {
            ListNode next = cur.next;
            int gcd = gcd(cur.val, next.val);
            ListNode newNode = new ListNode(gcd);
            cur.next = newNode;
            newNode.next = next;
            cur = next;
        }
        return head;
    }

    public int gcd(int a, int b) {
        return (a % b == 0) ? b : gcd(b, a % b);
    }

}
