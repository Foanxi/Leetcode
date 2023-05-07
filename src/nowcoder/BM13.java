package nowcoder;

import nowcoder.common.ListNode;

import java.util.Stack;

public class BM13 {
    public boolean isPail (ListNode head) {
        if (head == null){
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode dummyHead = head;
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        while (!stack.isEmpty()){
            if (dummyHead.val != stack.pop()){
                return false;
            }
            dummyHead = dummyHead.next;
        }
        return true;
    }
}
