package offer;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class T37 {
    class Codec {
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            // 使用BFS进行构建
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    TreeNode poll = queue.poll();
                    size--;
                    if (poll.val == Integer.MIN_VALUE) {
                        sb.append("#,");
                        continue;
                    }
                    sb.append(poll.val).append(",");
                    if (poll.left != null) {
                        queue.add(poll.left);
                    } else {
                        queue.add(new TreeNode(Integer.MIN_VALUE));
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    } else {
                        queue.add(new TreeNode(Integer.MIN_VALUE));
                    }
                }
            }
            return sb.toString();
        }

        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            String[] split = data.split(",");
            TreeNode head = new TreeNode(Integer.parseInt(split[0]));
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(head);
            for (int i = 1; i < split.length; i += 2) {
                TreeNode cur = queue.poll();
                if (!"#".equals(split[i])) {
                    cur.left = new TreeNode(Integer.parseInt(split[i]));
                    queue.add(cur.left);
                }
                if (!"#".equals(split[i + 1])) {
                    cur.right = new TreeNode(Integer.parseInt(split[i + 1]));
                    queue.add(cur.right);
                }
            }
            return head;
        }
    }
}
