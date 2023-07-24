package nowcoder;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hujinxu
 * @date 2023/7/24
 * @description
 */
public class BM24 {
    public int[] inorderTraversal(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void traversal(TreeNode root, List<Integer> res) {
        if (root.left != null) {
            traversal(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            traversal(root.right, res);
        }
    }
}
