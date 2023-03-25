package middle;

import common.ListNode;

import java.util.Random;

public class T382_getRandom {
    ListNode head;
    Random random;
    int length = 0;

    public T382_getRandom(ListNode head) {
        this.head = head;
        random = new Random();
        while (head != null) {
            length++;
            head = head.next;
        }
    }

    public int getRandom() {
        int r = random.nextInt(length);
        ListNode cur = head;
        for (int i=0;i<r;i++){
            cur = cur.next;
        }
        return cur.val;
    }
}
