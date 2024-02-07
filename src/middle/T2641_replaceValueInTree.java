package middle;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class T2641_replaceValueInTree {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        // 先跳过前两层
        queue.offer(root);
        int preSum = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            Map<TreeNode, Integer> map = new HashMap<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                poll.val = preSum - poll.val;
                int k = (poll.left == null ? 0 : poll.left.val) + (poll.right == null ? 0 : poll.right.val);
                sum += k;
                if (poll.left != null) {
                    queue.add(poll.left);
                    poll.left.val = k;
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                    poll.right.val = k;
                }
            }
            preSum = sum;
        }
        root.val = 0;
        return root;
    }
}
