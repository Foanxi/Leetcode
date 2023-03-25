package middle;

import common.TreeNode;

/**
 * @author foanxi
 */
public class T450_deleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }

    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = delete(root.right, key);
        } else if (root.val > key) {
            root.left = delete(root.left, key);
        } else {
            // 1.左右孩子都为空
            if (root.left == null && root.right == null) {
                return null;
            }
            // 2.左孩子为空而右孩子不为空
            else if (root.left == null) {
                return root.right;
            }
            // 3.右孩子为空而左孩子不为空
            else if (root.right == null) {
                return root.left;
            }
            // 4.左右孩子都不为空，此时将左孩子连接到右孩子的左链尾
            else {
                TreeNode temp = root.right;
                // 直到找到左链尾
                while (temp.left != null) {
                    temp = temp.left;
                }
                // 将左孩子连接到右子树的左链尾的左边
                temp.left = root.left;
                root = root.right;
            }
        }
        return root;
    }
}
