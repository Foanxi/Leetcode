package middle;

import common.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class T429_levelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> val = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                val.add(poll.val);
                queue.addAll(poll.children);
            }
            res.add(val);
        }
        return res;
    }
}
