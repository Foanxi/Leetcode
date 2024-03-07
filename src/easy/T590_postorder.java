package easy;

import common.Node;

import java.util.ArrayList;
import java.util.List;

public class T590_postorder {
    List<Integer> res = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root != null) {
            dfs(root);
        }
        return res;
    }

    public void dfs(Node node) {
        if (node == null) {
            return;
        }
        for (Node child : node.children) {
            dfs(child);
        }
        res.add(node.val);
    }
}
