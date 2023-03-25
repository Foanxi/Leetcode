package middle;

import common.TreeNode;

/**
 * @author foanxi
 */
public class T538_convertBST {
    TreeNode pre;

    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }

    public void traversal(TreeNode cur) {
        if (cur == null) {
            return;
        }
        traversal(cur.right);
        if (pre!=null){
            cur.val += pre.val;
        }
        pre = cur;
        traversal(cur.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode root1 = new TreeNode(6);
        TreeNode root2 = new TreeNode(7);
        TreeNode root3 = new TreeNode(8);
        TreeNode left = new TreeNode(5);

        root.right = root1;
        root1.right = root2;
        root2.right = root3;
        root1.left = left;
        new T538_convertBST().convertBST(root);
        System.out.println();

    }
}
