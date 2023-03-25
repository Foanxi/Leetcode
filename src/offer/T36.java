package offer;

public class T36 {
    Node pre,head;
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return root;
        }
        traversal(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    public void traversal(Node cur) {
        if (cur == null){
            return;
        }
        traversal(cur.left);
        // 中间处理
        if (pre == null){
            head = cur;
        }else {
            cur.left = pre;
            pre.right = cur;
        }
        pre = cur;
        traversal(cur.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
