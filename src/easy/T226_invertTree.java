package easy;

import common.TreeNode;

public class T226_invertTree {
    public TreeNode invertTree(TreeNode root) {
        invertTreeRegion(root);
        return root;
    }

    private void swap(TreeNode cur){
        TreeNode temp = cur.left;
        cur.left = cur.right;
        cur.right = temp;
    }

    private void invertTreeRegion(TreeNode treeNode){
        swap(treeNode);
        if (treeNode.left!=null){
            invertTreeRegion(treeNode.left);
        }
        if (treeNode.right!=null){
            invertTreeRegion(treeNode.right);
        }
    }
}
