package nowcoder;

import common.TreeNode;

/**
 * @author hujinxu
 */
public class BM30 {

    TreeNode head;
    TreeNode pre;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        traversal(pRootOfTree);
        return head;
    }

    public void traversal(TreeNode cur) {
        if (cur == null) {
            return;
        }
        traversal(cur.left);
        if (head == null) {
            head = cur;
        }
        if (pre != null) {
            pre.right = cur;
            cur.left = pre;
        }
        pre = cur;
        traversal(cur.right);
    }
}
