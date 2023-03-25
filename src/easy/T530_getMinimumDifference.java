package easy;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author foanxi
 */
public class T530_getMinimumDifference {

    List<Integer> list = new ArrayList<>();
    int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        getDiff(root);
        Collections.sort(list);
        for (int i = 0; i < list.size() - 1; i++) {
            minDiff = Math.min(list.get(i + 1) - list.get(i), minDiff);
        }
        return minDiff;
    }

    public void getDiff(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        getDiff(treeNode.left);
        list.add(treeNode.val);
        getDiff(treeNode.right);
    }

    TreeNode pre = null;

    public int getMinimumDifference2(TreeNode root) {
        getDiff2(root);
        return minDiff;
    }

    public void getDiff2(TreeNode cur) {
        if (cur == null) {
            return;
        }
        getDiff2(cur.left);
        if (pre!=null){
            minDiff = Math.min(minDiff, cur.val - pre.val);
        }
        pre = cur;
        getDiff2(cur.right);

    }
}
