package middle;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class T6308_kthLargestLevelSum {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<Long> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            list.add(sum);
        }
        list.sort((o1, o2) -> o2 - o1 >= 0 ? 1 : -1);
        if (k > list.size()) {
            return -1;
        }
        return list.get(k - 1);
    }
}
