package middle;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author foanxi
 */
public class T105_buildTree {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return traversal(inorder, 0, inorder.length, preorder, 0, preorder.length);
    }

    public TreeNode traversal(int[] inorder, int inBegin, int inEnd, int[] preorder, int preBegin, int preEnd) {
        if (inBegin >= inEnd || preBegin >= preEnd) {
            return null;
        }
        TreeNode cur = new TreeNode(preorder[preBegin]);
        int mid = map.get(cur.val);
        int range = mid - inBegin;
        cur.left = traversal(inorder, inBegin, mid, preorder, preBegin + 1, preBegin + range + 1);
        cur.right = traversal(inorder, mid + 1, inEnd, preorder, preBegin + range + 1, preEnd);
        return cur;
    }

}
