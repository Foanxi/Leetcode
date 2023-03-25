package middle;

public class T1599_minOperationsMaxProfit {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int sum = 0, cur = 0, n = customers.length;
        for (int customer : customers) {
            cur += customer;
            int t = Math.min(4, cur);
            sum += t * boardingCost - runningCost;
            cur -= t;
        }
        int cnt = cur / 4;
        int k = cur % 4;
        if (k * boardingCost > runningCost) {
            // 如果最后一波亏本停止轮转，免费运营
            cnt++;
        }
        sum += cur * boardingCost - cnt * runningCost;
        return sum > 0 ? cnt + n : -1;
    }
}
