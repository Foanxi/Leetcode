package middle;

import java.util.*;

public class T2368_reachableNodes {

    Set<Integer> visited = new HashSet<>();

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] map = new ArrayList[n];
        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }
        Set<Integer> restrict = new HashSet<>();
        for (int i : restricted) {
            restrict.add(i);
        }

        return dfs(0, map, restrict);
    }

    public int dfs(int cur, List<Integer>[] edge, Set<Integer> restricted) {
        if (restricted.contains(cur) || visited.contains(cur)) {
            return 0;
        }
        visited.add(cur);
        int sum = 1;
        for (int i : edge[cur]) {
            sum += dfs(i, edge, restricted);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] edge = {{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}};
        System.out.println(new T2368_reachableNodes().reachableNodes(7, edge, new int[]{4, 5}));
    }
}
