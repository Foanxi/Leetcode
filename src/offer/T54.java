package offer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T54 {
    List<Integer> num = new ArrayList<>();

    public int kthLargest2(TreeNode root, int k) {
        traversal2(root);
        return num.get(num.size() - k);
    }

    public void traversal2(TreeNode cur) {
        if (cur == null) {
            return;
        }
        traversal2(cur.left);
        num.add(cur.val);
        traversal2(cur.right);
    }

    int result = 0;
    int index = 0;

    public int kthLargest(TreeNode root, int k) {
        traversal(root,k);
        return result;
    }

    public void traversal(TreeNode cur, int k) {
        if (cur == null) {
            return;
        }
        traversal(cur.right, k);
        if (++index == k) {
            result = cur.val;
            return;
        }
        traversal(cur.left, k);
    }
}
