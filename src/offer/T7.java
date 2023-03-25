package offer;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author foanxi
 */
public class T7 {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 创建先序遍历的时候，对应的值在中序遍历中的位置
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return traversal(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode traversal(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        if (preBegin >= preEnd) {
            return null;
        }
        int cur = preorder[preBegin];
        int mid = map.get(cur);
        int interval = mid - inBegin;
        TreeNode root = new TreeNode(cur);
        root.left = traversal(preorder, preBegin + 1, preBegin + interval + 1, inorder, inBegin, mid);
        root.right = traversal(preorder, preBegin + interval + 1, preEnd, inorder, mid + 1, inEnd);
        return root;
    }
}
