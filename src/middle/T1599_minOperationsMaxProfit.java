package middle;

public class T1599_minOperationsMaxProfit {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int wait = 0, sum = 0, res = 0, total = 0;
        for (int customer : customers) {
            total += customer;
        }
        for (int customer : customers) {
            wait += customer;
            int up = Math.min(4, wait);
            sum += up * boardingCost - runningCost;
            wait -= up;
            total -= customer;
            if (total == 0 && up == 0) {
                break;
            }
            res++;
        }
        res += wait / 4;
        int rest = wait % 4;
        if (rest * boardingCost > runningCost) {
            res++;
        }
        return sum > 0 ? res : -1;
    }
}
