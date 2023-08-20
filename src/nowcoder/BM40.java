package nowcoder;

import common.TreeNode;

/**
 * @author foanxi
 */
public class BM40 {
    public TreeNode reConstructBinaryTree(int[] preOrder, int[] vinOrder) {
        return traversal(preOrder, 0, preOrder.length, vinOrder, 0, vinOrder.length);
    }

    public TreeNode traversal(int[] preOrder, int preStart, int preEnd, int[] vinOrder, int vinStart, int vinEnd) {
        if (preEnd <= preStart) {
            return null;
        }
        int cur = preOrder[preStart];
        TreeNode root = new TreeNode(cur);
        int index = find(vinOrder, cur);
        root.left = traversal(preOrder, preStart + 1, index + 1 - vinStart + preStart, vinOrder, vinStart, index);
        root.right = traversal(preOrder, index + 1 - vinStart + preStart, preEnd, vinOrder, index + 1, vinEnd);
        return root;
    }

    public int find(int[] vinOrder, int target) {
        for (int i = 0; i < vinOrder.length; i++) {
            if (vinOrder[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new BM40().reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
    }

}
