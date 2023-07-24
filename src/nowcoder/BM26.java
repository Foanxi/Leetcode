package nowcoder;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author hujinxu
 */
public class BM26 {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                list.add(poll.val);
                size--;
            }
            res.add(list);
        }
        return res;
    }
}
