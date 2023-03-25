package middle;

import common.TreeNode;

import java.util.HashMap;

public class T337_rob {
    public HashMap<TreeNode, Integer> map = new HashMap<>();

    /**
     * 通过记忆化搜索+回溯算法求得
     *
     * @param root 根节点/当前节点
     * @return 返回最大价值
     */
    public int rob2(TreeNode root) {
        if (map.containsKey(root)) {
            return map.get(root);
        }
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        // 决定偷当前节点
        int val = root.val;
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }

        // 不偷当前节点
        int val2 = rob(root.left) + rob(root.right);
        map.put(root, Math.max(val, val2));
        return Math.max(val, val2);
    }


    public int rob(TreeNode root) {
        int[] rob = traversal(root);
        return Math.max(rob[0], rob[1]);
    }

    /**
     * dp数组分别表示不偷和偷
     *
     * @param cur 根节点/当前节点
     * @return 返回最大价值
     */
    public int[] traversal(TreeNode cur) {
        if (cur == null) {
            return new int[]{0, 0};
        }
        int[] left = traversal(cur.left);
        int[] right = traversal(cur.right);
        return new int[]{Math.max(left[0], left[1]) + Math.max(right[0], right[1]), cur.val + left[0] + right[0],};
    }
}
