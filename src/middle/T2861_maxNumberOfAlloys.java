package middle;

import java.util.List;

public class T2861_maxNumberOfAlloys {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int res = 0;
        for (List<Integer> machine : composition) {
            int left = 0;
            int right = 100_000_0000;
            int max = 0;
            while (left < right) {
                // 判断当前能否满足
                int mid = (right - left) / 2 + left;
                if (check(machine, stock, cost, budget, mid)) {
                    left = mid + 1;
                    max = mid;
                } else {
                    right = mid;
                }
            }
            res = Math.max(res, max);
        }
        return res;
    }

    private boolean check(List<Integer> machine, List<Integer> stock, List<Integer> cost, long budget, int need) {
        for (int i = 0; i < machine.size(); i++) {
            long last = (long) machine.get(i) * need - stock.get(i);
            if (last > 0) {
                budget -= cost.get(i) * last;
            }
            if (budget < 0) {
                return false;
            }
        }
        return true;
    }
}
