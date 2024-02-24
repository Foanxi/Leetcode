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
        Queue<Long> max = new PriorityQueue<>(k);
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
            if (max.size() < k) {
                max.add(sum);
            } else {
                if (max.peek() < sum) {
                    max.poll();
                    max.add(sum);
                }
            }
        }
        if (k > max.size()) {
            return -1;
        }
        return max.poll();
    }
}
