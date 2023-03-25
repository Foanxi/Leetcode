package middle;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author foanxi
 */
public class T113_pathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        List<Integer> path = new ArrayList<>();
        traversal(root, path, result, targetSum);
        return result;
    }

    public void traversal(TreeNode treeNode, List<Integer> path, List<List<Integer>> result, int rest) {
        path.add(treeNode.val);

        if (rest - treeNode.val == 0 && treeNode.left == null && treeNode.right == null) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (treeNode.left != null) {
            traversal(treeNode.left, path, result, rest - treeNode.val);
            path.remove(path.size()-1);
        }
        if (treeNode.right != null) {
            traversal(treeNode.right, path, result, rest - treeNode.val);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left1 = new TreeNode(4);
        TreeNode left2 = new TreeNode(11);
        TreeNode left3 = new TreeNode(7);
        TreeNode right4 = new TreeNode(2);
        root.left = left1;
        left1.left = left2;
        left2.left = left3;
        left2.right = right4;
        System.out.println(new T113_pathSum().pathSum(root, 22));
    }
}
