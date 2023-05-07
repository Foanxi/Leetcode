package nowcoder;

import nowcoder.common.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author foanxi
 */
public class BM12 {
    public ListNode sortInList (ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        dummyHead.next = cur;
        for (int num:list){
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
