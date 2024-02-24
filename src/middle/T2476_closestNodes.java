package middle;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T2476_closestNodes {

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tree = new ArrayList<>();
        dfs(root, tree);
        for (Integer query : queries) {
            int min = -1, max = -1;
            List<Integer> temp = new ArrayList<>();
            int index = binarySearch(tree, query);
            if (index < tree.size()) {
                max = tree.get(index);
                if (tree.get(index).equals(query)) {
                    min = tree.get(index);
                }
            }
            if (min == -1 && index > 0) {
                min = tree.get(index - 1);
            }
            temp.add(min);
            temp.add(max);
            res.add(temp);
        }
        return res;
    }

    public int binarySearch(List<Integer> tree, int target) {
        int left = 0;
        int right = tree.size();
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (tree.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public void dfs(TreeNode root, List<Integer> tree) {
        if (root == null) {
            return;
        }
        dfs(root.left, tree);
        tree.add(root.val);
        dfs(root.right, tree);
    }

    /**
     * 第一种做法，但是会因为树不是平衡的，可能存在超时的情况，废弃
     */
    @Deprecated
    public List<List<Integer>> closestNodes2(TreeNode root, List<Integer> queries) {
        List<List<Integer>> res = new ArrayList<>();
        for (int query : queries) {
            List<Integer> temp = new ArrayList<>();
            int min = dfsMin(root, query, -1);
            int max = dfsMax(root, query, -1);
            temp.add(min);
            temp.add(max);
            res.add(temp);
        }
        return res;
    }

    @Deprecated
    public int dfsMin(TreeNode cur, int val, int pre) {
        if (cur == null) {
            return pre;
        }
        if (cur.val > val) {
            return dfsMin(cur.left, val, pre);
        } else if (cur.val == val) {
            return cur.val;
        } else {
            return dfsMin(cur.right, val, cur.val);
        }
    }

    @Deprecated
    public int dfsMax(TreeNode cur, int val, int pre) {
        if (cur == null) {
            return pre;
        }
        if (cur.val < val) {
            return dfsMax(cur.right, val, pre);
        } else if (cur.val == val) {
            return cur.val;
        } else {
            return dfsMax(cur.left, val, cur.val);
        }
    }
}
