package nowcoder;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

/**
 * @author hujinxu
 */
public class BM27 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        queue.add(pRoot);
        boolean flag = false;
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
            if (flag) {
                Collections.reverse(list);
            }
            flag = !flag;
            res.add(list);
        }
        return res;
    }
}
