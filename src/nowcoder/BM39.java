package nowcoder;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class BM39 {
    String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                sb.append(poll.val).append(",");
                if (poll.val == -1) {
                    size--;
                    continue;
                }
                queue.add(poll.left == null ? new TreeNode(-1) : poll.left);
                queue.add(poll.right == null ? new TreeNode(-1) : poll.right);
                size--;
            }
        }
        return sb.toString();
    }


    TreeNode Deserialize(String str) {
        if ("".equals(str)) {
            return null;
        }
        String[] split = str.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        for (int i = 1; i < split.length; i += 2) {
            TreeNode cur = queue.poll();
            if (!"-1".equals(split[i])) {
                cur.left = new TreeNode(Integer.parseInt(split[i]));
                queue.add(cur.left);
            }
            if (i < split.length - 1 && !"-1".equals(split[i + 1])) {
                cur.right = new TreeNode(Integer.parseInt(split[i + 1]));
                queue.add(cur.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(6);
        TreeNode root4 = new TreeNode(7);
        root.left = root1;
        root.right = root2;
        root2.left = root3;
        root2.right = root4;
        System.out.println(new BM39().Serialize(root));
    }
}
