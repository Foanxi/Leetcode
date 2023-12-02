package middle;

import common.TreeNode;

public class T1457_pseudoPalindromicPaths {
    int res = 0;

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(1);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;

        new T1457_pseudoPalindromicPaths().pseudoPalindromicPaths(t1);
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        traversal(root, new int[10]);
        return res;
    }

    public boolean isValid(int[] count) {
        boolean flag = false;
        for (int num : count) {
            if (num % 2 != 0) {
                if (flag) {
                    return false;
                }
                flag = true;
            }
        }
        return true;
    }

    public void traversal(TreeNode treeNode, int[] count) {
        if (treeNode.left == null && treeNode.right == null) {
            count[treeNode.val]++;
            if (isValid(count)) {
                res++;
            }
            count[treeNode.val]--;
            return;
        }
        count[treeNode.val]++;
        if (treeNode.left != null) {
            traversal(treeNode.left, count);
        }
        if (treeNode.right != null) {
            traversal(treeNode.right, count);
        }
        count[treeNode.val]--;
    }
}
