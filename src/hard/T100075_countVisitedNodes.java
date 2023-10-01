package hard;

import java.util.Arrays;
import java.util.List;

/**
 * @author foanxi
 */
public class T100075_countVisitedNodes {
    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        boolean[] visited = new boolean[n];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = dfs(i, edges, visited);
        }
        return res;
    }

    public int dfs(int cur, List<Integer> edges, boolean[] visited) {
        if (visited[cur]) {
            return 0;
        }
        visited[cur] = true;
        int dfs = dfs(edges.get(cur), edges, visited);
        return dfs + 1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T100075_countVisitedNodes().countVisitedNodes(Arrays.asList(1, 2, 0, 0))));
    }
}
