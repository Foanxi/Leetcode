package middle;

import java.util.*;

public class T1466_minReorder {

    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(new T1466_minReorder().minReorder(6, grid));
//        Set<int[]> set = new HashSet<>();
//        set.add(new int[]{1,0});
//        System.out.println(set.contains(new int[]{1,0}));
    }

    int res = 0;

    public int minReorder(int n, int[][] connections) {
        List<Integer>[] map = new ArrayList[n + 1];
        Set<String> exist = new HashSet<>();
        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] cur : connections) {
            map[cur[0]].add(cur[1]);
            map[cur[1]].add(cur[0]);
            exist.add(cur[0] + ":" + cur[1]);
        }
        bfs(0, map, -1, exist);
        return res;
    }

    public void bfs(int cur, List<Integer>[] map, int parent, Set<String> exist) {
        // 获取当前相连的节点
        for (int i : map[cur]) {
            if (i != parent) {
                // 检查当前的节点指向是否父节点,不是反转
                bfs(i, map, cur, exist);
                if (exist.contains(cur + ":" + i)) {
                    res++;
                }
            }
        }
    }
}
