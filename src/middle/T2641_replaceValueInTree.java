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
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            Map<TreeNode, Integer> map = new HashMap<>();
            Queue<TreeNode> temp = new ArrayDeque<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                temp.add(poll);
                if (poll.left != null) {
                    queue.add(poll.left);
                    sum += poll.left.val;
                }
                if (poll.right != null) {
                    queue.add(poll.right.right);
                }
            }
            for (int i = 0; i < size; i++) {
                TreeNode poll = temp.poll();
                int val = 0;
                if (poll.left != null) {
                    val += poll.left.val;
                }
                if (poll.right != null) {
                    val += poll.right.val;
                }
                if (poll.left != null) {
                    poll.left.val = sum -= val;
                }
                if (poll.right != null) {
                    poll.right.val = sum -= val;
                }
            }
        }
        root.val = 0;
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(10);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.right = treeNode5;
        new T2641_replaceValueInTree().replaceValueInTree(treeNode);
    }
}
