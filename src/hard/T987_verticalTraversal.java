package hard;

import common.TreeNode;

import java.util.*;

public class T987_verticalTraversal {

    static class Temp implements Comparable<Temp> {
        int val;
        int depth;

        public Temp(int val, int depth) {
            this.val = val;
            this.depth = depth;
        }

        public int getVal() {
            return val;
        }

        @Override
        public int compareTo(Temp o) {
            if (o.depth == this.depth) {
                return this.val - o.val;
            } else return this.depth - o.depth;
        }
    }

    Map<Integer, PriorityQueue<Temp>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (PriorityQueue<Temp> value : map.values()) {
            List<Integer> list = new ArrayList<>();
            while (!value.isEmpty()) {
                list.add(value.poll().val);
            }
            res.add(list);
        }
        return res;
    }

    public void dfs(TreeNode node, int index, int depth) {
        if (node == null) {
            return;
        }
        PriorityQueue<Temp> list = map.getOrDefault(index, new PriorityQueue<>());
        list.add(new Temp(node.val, depth));
        map.put(index, list);
        dfs(node.left, index - 1, depth + 1);
        dfs(node.right, index + 1, depth + 1);
    }
}
