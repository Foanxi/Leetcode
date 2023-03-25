package middle;

import common.TreeNode;

import java.util.HashMap;

/**
 * @author foanxi
 */
public class T106_buildTree {
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return traversal(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode traversal(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        if (inBegin >= inEnd || postBegin >= postEnd) {
            return null;
        }
        int midValue = postorder[postEnd - 1];
        // 当前情况下的根节点
        TreeNode root = new TreeNode(midValue);
        // 需要切分的位置
        int midIndex = hashMap.get(midValue);
        // 此时左子树的中序范围是从上一个inBegin到中间值-1的位置，右子树的中序范围为中间值-1到postEnd
        // 左子树的后序范围为大小相同
        int leftInOrderSize = midIndex - inBegin;
        root.left = traversal(inorder, inBegin, midIndex, postorder, postBegin, postBegin+leftInOrderSize);
        root.right = traversal(inorder, midIndex + 1, inEnd, postorder, postBegin + leftInOrderSize, postEnd-1);
        return root;
    }
}
