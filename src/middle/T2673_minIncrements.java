package middle;

public class T2673_minIncrements {
    public int minIncrements(int n, int[] cost) {
        int res = 0;
        // depth决定了当前层数有几个节点
        for (int i = n - 2; i > 0; i -= 2) {
            res += Math.abs(cost[i] - cost[i + 1]);
            cost[i / 2] += Math.max(cost[i], cost[i + 1]);
        }
        return res;
    }
}
