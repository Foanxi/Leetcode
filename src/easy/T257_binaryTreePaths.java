package easy;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author foanxi
 */
public class T257_binaryTreePaths {

    /**
     * 递归法求所有路径
     *
     * @param root 根节点
     * @return 返回所有路径
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        getPath(root, path, result);
        return result;
    }

    public void getPath(TreeNode treeNode, List<Integer> path, List<String> result) {
        path.add(treeNode.val);
        if (treeNode.left == null && treeNode.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size() - 1));
            result.add(sb.toString());
            return;
        }

        if (treeNode.left != null) {
            getPath(treeNode.left, path, result);
            path.remove(path.size() - 1);
        }
        if (treeNode.right != null) {
            getPath(treeNode.right, path, result);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 迭代法求所有路径
     *
     * @param root 根节点
     * @return 所有叶子节点路径
     */
    public List<String> binaryTreePaths2(TreeNode root) {

        List<String> result = new ArrayList<>();
        if (root==null){
            return result;
        }
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        stack.push(root.val + "");

        while (!stack.isEmpty()){
            String path = (String) stack.pop();
            TreeNode cur = (TreeNode) stack.pop();
            if (cur.left == null&& cur.right==null){
                result.add(path);
            }

            // 注意右节点先入栈才是正确的前序遍历
            if (cur.right !=null){
                stack.push(cur.right);
                stack.push(path + "->" + cur.right.val);
            }

            if (cur.left!=null){
                stack.push(cur.left);
                stack.push(path + "->" + cur.left.val);
            }
        }

        return result;
    }
}
