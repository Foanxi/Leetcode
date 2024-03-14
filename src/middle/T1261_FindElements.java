package middle;

import common.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class T1261_FindElements {

    Set<Integer> set = new HashSet<>();

    public T1261_FindElements(TreeNode root) {
        dfs(root, 0);
    }

    public void dfs(TreeNode cur, int val) {
        if (cur == null) {
            return;
        }
        cur.val = val;
        set.add(val);
        dfs(cur.left, val * 2 + 1);
        dfs(cur.right, val * 2 + 2);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
