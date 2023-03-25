package offer;

import common.ListNode;

public class T6 {
    public int[] reversePrint(ListNode head) {
        int[] pre = new int[10000];
        int j = 0;
        while (head != null) {
            pre[j] = head.val;
            head = head.next;
            j++;
        }
        int[] result = new int[j];
        for (int i = 0; i < j; i++) {
            result[i] = pre[j - i - 1];
        }
        return result;
    }
}
