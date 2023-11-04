package hard;

import java.util.*;

/**
 * @author foanxi
 */
public class T2003_smallestMissingValueSubtree {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        List<Integer>[] children = new ArrayList[n];
        for (int i = 0; i < parents.length; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i < parents.length; i++) {
            children[parents[i]].add(i);
        }
        int[] res = new int[n];
        Arrays.fill(res, 1);
        // 代表已经有的基因值的集合
        Set<Integer> geneSet = new HashSet<>();
        // minGene表示是当前的最小基因
        int minGene = 1, node = -1;
        // 如果找到1的节点,则去找他的所有父节点,并且将它的所有父节点都依次枚举
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                node = i;
                break;
            }
        }
        boolean[] visited = new boolean[n];
        while (node != -1) {
            dfs(node, children, geneSet, nums, visited);
            while (geneSet.contains(minGene)) {
                minGene++;
            }
            res[node] = minGene;
            node = parents[node];
        }
        return res;
    }

    public void dfs(int cur, List<Integer>[] children, Set<Integer> geneSet, int[] nums, boolean[] visited) {
        if (visited[cur]) {
            return;
        }
        visited[cur] = true;
        // 将当前的基因值添加到集合中
        geneSet.add(nums[cur]);
        for (int child : children[cur]) {
            dfs(child, children, geneSet, nums, visited);
        }
    }
}
