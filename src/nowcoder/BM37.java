package nowcoder;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author hujinxu
 */
public class BM37 {

    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        Queue<TreeNode> q1 = new ArrayDeque<>();
        Queue<TreeNode> q2 = new ArrayDeque<>();
        traversal(root, p, q1);
        traversal(root, q, q2);
        TreeNode pre = q1.peek();
        while (!q1.isEmpty() && q1.peek() == q2.peek()){
            pre = q1.poll();
            q2.poll();
        }
        return pre.val;
    }

    public void traversal(TreeNode cur, int target, Queue<TreeNode> stack) {
        stack.add(cur);
        if (cur.val == target) {
            return;
        }
        if (cur.val > target) {
            traversal(cur.left, target, stack);
        }
        if (cur.val < target) {
            traversal(cur.right, target, stack);
        }
    }
}
