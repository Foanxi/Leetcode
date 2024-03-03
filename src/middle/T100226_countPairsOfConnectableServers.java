package middle;

import java.util.*;

public class T100226_countPairsOfConnectableServers {
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        List<int[]>[] map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            map[e[0]].add(e);
            map[e[1]].add(new int[]{e[1], e[0], e[2]});
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (map[i].size() <= 1) {
                res[i] = 0;
                continue;
            }
            // 遍历每个节点查询a到当前节点的距离，同时查询b到当前节点的距离，此处构造arraylist可以保证边来自不同方位，避免公共边的存在
            List<Integer> total = new ArrayList<>();
            // 各自从连接段进入深度遍历
            for (int[] ints : map[i]) {
                dfs(ints[1], ints[2], map, new boolean[n], signalSpeed, ints[0]);
                total.add(count);
                count = 0;
            }
            int sum = 0;
            for (int j = 0; j < total.size(); j++) {
                for (int t = j + 1; t < total.size(); t++) {
                    sum += total.get(t) * total.get(j);
                }
            }
            res[i] = sum;
        }
        return res;
    }

    int count = 0;

    public void dfs(int cur, int sum, List<int[]>[] edge, boolean[] visited, int signalSpeed, int prev) {
        if (visited[cur]) {
            return;
        }
        visited[cur] = true;
        if (sum % signalSpeed == 0) {
            count++;
        }
        for (int[] ints : edge[cur]) {
            if (ints[1] == prev) {
                continue;
            }
            dfs(ints[1], sum + ints[2], edge, visited, signalSpeed, cur);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T100226_countPairsOfConnectableServers().countPairsOfConnectableServers(new int[][]{{0, 1, 1}, {1, 2, 5}, {2, 3, 13}, {3, 4, 9}, {4, 5, 2}}, 1)));
    }
}
