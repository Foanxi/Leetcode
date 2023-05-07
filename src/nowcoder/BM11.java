package nowcoder;

import nowcoder.common.ListNode;

import java.util.Stack;

public class BM11 {
    public ListNode addInList(ListNode head1, ListNode head2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (head1 != null) {
            stack1.push(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2);
            head2 = head2.next;
        }
        int next = 0;
        ListNode dummyHead = new ListNode(-1);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int val = next;
            if (!stack1.isEmpty()) {
                val += stack1.pop().val;
            }
            if (!stack2.isEmpty()) {
                val += stack2.pop().val;
            }
            next = val / 10;
            ListNode node = new ListNode(val % 10);
            node.next = dummyHead.next;
            dummyHead.next = node;
        }
        if (next > 0){
            ListNode node = new ListNode(next);
            node.next = dummyHead.next;
            dummyHead.next = node;
        }
        return dummyHead.next;
    }
}
