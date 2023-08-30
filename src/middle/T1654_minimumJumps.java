package middle;

import java.util.*;

/**
 * @author foanxi
 */
public class T1654_minimumJumps {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> forbiddenSet = new HashSet<>();
        for (int num : forbidden) {
            forbiddenSet.add(num);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        // 统计上下限，下限为0，上限为禁区内最大值加a加b和x中取最大值
        int upper = Math.max(Arrays.stream(forbidden).max().getAsInt() + a + b, x);
        Queue<int[]> queue = new ArrayDeque<>();
        // 先添加一开始的坐标
        // 第一位表示当前坐标，第二位表示方向（1为前进，-1为后退），第三位表示当前已经走了多少步
        queue.add(new int[]{0, 1, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cur = poll[0];
            if (cur == x) {
                return poll[2];
            }
            // 尝试前进
            if (cur + a <= upper && !forbiddenSet.contains(cur + a) && !visited.contains(cur + a)) {
                visited.add(cur + a);
                queue.add(new int[]{cur + a, 1, poll[2] + 1});
            }
            // 查看能否后退
            if (poll[1] == 1 && cur - b >= 0 && !forbiddenSet.contains(cur - b) && !visited.contains(cur - b)) {
                visited.add(cur - b);
                queue.add(new int[]{cur - b, -1, poll[2] + 1});
            }
        }
        return -1;
    }
}