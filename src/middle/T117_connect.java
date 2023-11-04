package middle;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author foanxi
 */
public class T117_connect {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size == 1) {
                Node cur = queue.poll();
                cur.next = null;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            } else {
                Node prev = queue.poll();
                if (prev.left != null) {
                    queue.offer(prev.left);
                }
                if (prev.right != null) {
                    queue.offer(prev.right);
                }
                for (int i = 0; i < size - 1; ++i) {
                    Node cur = queue.poll();
                    prev.next = cur;
                    prev = prev.next;
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
            }
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
