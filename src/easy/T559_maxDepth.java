package easy;

import common.Node;
import common.TreeNode;

import java.util.*;

public class T559_maxDepth {
    /**
     * 迭代方法，广度搜索
     *
     * @param root 需要得到深度的树的根节点
     * @return 返回树的深度
     */
    public int maxDepth(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        int result = 0;
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                for (Node child : cur.children) {
                    if (child != null) {
                        queue.add(child);
                    }
                }
            }
            result++;
        }
        return result;
    }

    /**
     * 递归方法，深度搜索
     *
     * @param root 需要得到深度的树的根节点
     * @return 返回树的深度
     */
    public int maxDepth2(Node root) {
        return getDepth(root);
    }

    public int getDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        for (Node child : root.children) {
            depth = Math.max(depth,maxDepth(child));
        }
        return depth+1;
    }
}
