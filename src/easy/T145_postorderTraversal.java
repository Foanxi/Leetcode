package easy;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author foanxi
 */
public class T145_postorderTraversal {
    List<Integer> list = new ArrayList<>();

    /**
     * 使用迭代法进行后序遍历
     *
     * @param root 需要遍历的树的根节点
     * @return 返回树的后序遍历
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            stack.pop();
            list.add(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        Collections.reverse(list);
        return list;
    }

    /**
     * 使用迭代法进行后序遍历
     *
     * @param root 需要遍历的树的根节点
     * @return 返回树的后序遍历
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root != null) {
            preorderTraversal3(root);
        }
        return list;
    }

    public void preorderTraversal3(TreeNode node) {
        if (node != null) {
            preorderTraversal3(node.left);
            preorderTraversal3(node.right);
            list.add(node.val);
        }
    }
}
