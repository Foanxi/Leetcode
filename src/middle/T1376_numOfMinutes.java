package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author foanxi
 */
public class T1376_numOfMinutes {
    /**
     * @param n          员工数量
     * @param headID     总负责人
     * @param manager    员工数组
     * @param informTime 通知时间数组
     * @return 通知所有员工所需要的时间
     */
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            map.putIfAbsent(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        return dfs(map, informTime, headID);
    }

    public int dfs(Map<Integer, List<Integer>> map, int[] informTime, int cur) {
        int res = 0;
        for (int neighbour : map.getOrDefault(cur, new ArrayList<>())) {
            res = Math.max(dfs(map, informTime, neighbour), res);
        }
        return informTime[cur] + res;
    }
}
