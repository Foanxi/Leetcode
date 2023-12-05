package middle;

import java.util.ArrayList;
import java.util.List;

public class T2477_minimumFuelCost {
    long res = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        List<Integer>[] map = new ArrayList[roads.length + 1];
        for (int i = 0; i <= roads.length; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] cur : roads) {
            map[cur[0]].add(cur[1]);
        }
        dfs(0, map, seats);
        return res;
    }

    public int dfs(int cur, List<Integer>[] map, int seats) {
        // 遍历当前节点的子节点
        int sum = 1;
        for (int child : map[cur]) {
            int dfs = dfs(child, map, seats);
            sum += dfs;
        }
        if (cur != 0) {
            res += (int) Math.ceil((double) sum / seats);
        }
        return sum;
    }
}
