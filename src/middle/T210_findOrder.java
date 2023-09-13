package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author foanxi
 */
public class T210_findOrder {
    int index;
    List<List<Integer>> edges = new ArrayList<>();
    boolean valid = true;
    int[] res;
    int[] visited;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res = new int[numCourses];
        index = numCourses - 1;
        // 0表示未搜索，1表示搜索中，2表示有已搜索
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] cur : prerequisites) {
            edges.get(cur[1]).add(cur[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid) {
            return new int[0];
        } else {
            return res;
        }
    }

    public void dfs(int cur) {
        visited[cur] = 1;
        // 遍历每条边
        for (int num : edges.get(cur)) {
            // 说明存在环
            if (visited[num] == 1) {
                valid = false;
                return;
            } else if (visited[num] == 0) {
                dfs(num);
                if (!valid) {
                    return;
                }
            }
        }
        visited[cur] = 2;
        res[index--] = cur;
    }
}
