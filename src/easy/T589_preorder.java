package easy;

import common.Node;

import java.util.ArrayList;
import java.util.List;

public class T589_preorder {

    List<Integer> res = new ArrayList<>();


    public List<Integer> preorder(Node root) {
        dfs(root);
        return res;
    }

    public void dfs(Node node) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        for (Node child : node.children) {
            dfs(child);
        }
    }
}
