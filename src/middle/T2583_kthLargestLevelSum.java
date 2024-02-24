package middle;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class T2583_kthLargestLevelSum {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        // 对于比int类型精度更大的类型，只能使用该办法,使用16行的方式会出现错误
        // Queue<Long> max = new PriorityQueue<>((o1, o2) -> (int) (o2 - o1));
        Queue<Long> max = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            max.add(sum);
        }
        if (k > max.size()) {
            return -1;
        }
        for (int i = 0; i < k - 1; i++) {
            max.poll();
        }
        return max.poll();
    }
}
