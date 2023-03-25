package easy;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author foanxi
 */
public class T501_findMode {
    TreeNode pre = null;
    int count = 0;
    int maxCount = Integer.MIN_VALUE;
    List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        traversal(root);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public void traversal(TreeNode cur) {
        if (cur == null) {
            return;
        }
        traversal(cur.left);
        if (pre != null && pre.val == cur.val) {
            count++;
        } else {
            count = 1;
        }
        pre = cur;
        if (count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(cur.val);
        }else if (count == maxCount){
            list.add(cur.val);
        }
        traversal(cur.right);
    }
}
