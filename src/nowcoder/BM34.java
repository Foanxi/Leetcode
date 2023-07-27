package nowcoder;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hujinxu
 */
public class BM34 {

    TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        return traversal(root);
    }

    public boolean traversal(TreeNode cur) {
        if (cur == null) {
            return true;
        }
        if (!traversal(cur.left)) {
            return false;
        }
        if (pre == null) {
            pre = cur;
        }
        if (pre.val > cur.val) {
            return false;
        }
        pre = cur;
        return traversal(cur.right);
    }

    public boolean isValidBST2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal2(root, list);
        for (int i = 0; i < list.size() - 1; ++i) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void traversal2(TreeNode cur, List<Integer> list) {
        if (cur == null) {
            return;
        }
        traversal2(cur.left, list);
        list.add(cur.val);
        traversal2(cur.right, list);
    }
}
