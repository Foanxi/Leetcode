package easy;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author foanxi
 */
public class T144_preorderTraversal {
    List<Integer> list = new ArrayList<>();

    /**
     * 使用迭代法进行前序遍历
     *
     * @param root 需要遍历的树的根节点
     * @return 返回树的前序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            stack.pop();
            list.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return list;
    }

    /**
     * 使用递归法进行前序遍历
     *
     * @param root 需要遍历的树的根节点
     * @return 返回树的前序遍历
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root != null) {
            preorderTraversal2recursion(root);
        }
        return list;
    }

    public void preorderTraversal2recursion(TreeNode node) {
        if (node != null) {
            list.add(node.val);
            preorderTraversal2recursion(node.left);
            preorderTraversal2recursion(node.right);
        }
    }
}