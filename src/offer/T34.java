package offer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T34 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        path.add(root.val);
        traversal(root, target, root.val);
        return res;
    }

    public void traversal(TreeNode root, int target, int sum) {
        if (sum == target && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        if (root.left != null) {
            path.add(root.left.val);
            traversal(root.left, target, sum + root.left.val);
            path.removeLast();
        }

        if (root.right != null) {
            path.add(root.right.val);
            traversal(root.right, target, sum + root.right.val);
            path.removeLast();
        }
    }
}
