package easy;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author foanxi
 */
public class T94_inorderTraversal {
    List<Integer> list = new ArrayList<>();

    /**
     * 使用迭代法进行中序遍历
     *
     * @param root 需要遍历的树的根节点
     * @return 返回树的中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }

    /**
     * 使用迭代法进行中序遍历
     *
     * @param root 需要遍历的树的根节点
     * @return 返回树的中序遍历
     */
    public List<Integer> inorderTraversalMain(TreeNode root) {
        if (root != null) {
            preorderTraversal2(root);
        }
        return list;
    }

    public void preorderTraversal2(TreeNode node) {
        if (node != null) {
            preorderTraversal2(node.left);
            list.add(node.val);
            preorderTraversal2(node.right);
        }
    }

    /**
     * 使用标记迭代法进行中序遍历
     *
     * @param root 需要遍历的树的根节点
     * @return 返回树的中序遍历
     */
    public List<Integer> inorderTraversalMark(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur != null) {
                // 这里是避免连续添加两次中间节点
                stack.pop();
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                stack.push(cur);
                stack.push(null);
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            } else {
                stack.pop();
                cur = stack.pop();
                list.add(cur.val);
            }
        }
        return list;
    }
}
