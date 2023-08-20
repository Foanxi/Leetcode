package nowcoder;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author foanxi
 */
public class BM41 {
    public int[] solve(int[] preOrder, int[] inOrder) {
        TreeNode treeNode = reConstructBinaryTree(preOrder, inOrder);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                if (size == 1) {
                    list.add(poll.val);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                size--;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public TreeNode reConstructBinaryTree(int[] preOrder, int[] vinOrder) {
        return traversal(preOrder, 0, preOrder.length, vinOrder, 0, vinOrder.length);
    }

    public TreeNode traversal(int[] preOrder, int preStart, int preEnd, int[] vinOrder, int vinStart, int vinEnd) {
        if (preEnd <= preStart) {
            return null;
        }
        int cur = preOrder[preStart];
        TreeNode root = new TreeNode(cur);
        int index = find(vinOrder, cur);
        root.left = traversal(preOrder, preStart + 1, index + 1 - vinStart + preStart, vinOrder, vinStart, index);
        root.right = traversal(preOrder, index + 1 - vinStart + preStart, preEnd, vinOrder, index + 1, vinEnd);
        return root;
    }

    public int find(int[] vinOrder, int target) {
        for (int i = 0; i < vinOrder.length; i++) {
            if (vinOrder[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
