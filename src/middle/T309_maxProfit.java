package middle;

/**
 * @author foanxi
 */
public class T309_maxProfit {
    public int maxProfit(int[] prices) {
        // dp[i]表示当前处于第i种状态
        // 0 表示当前持有股票
        // 1 表示保持卖出股票的状态，可以是前一天卖出，也可以是冷静期刚结束
        // 2 表示今天卖出股票
        // 3 表示冷冻期
        int[] dp = new int[4];
        dp[0] -= prices[0];

        for (int i = 1; i <= prices.length; i++) {
            int temp = dp[0];
            int temp2 = dp[2];
            // 对于当前持有股票来说，可能是因为之前持有，也可能是因为今天买入，还可能是因为冷冻期刚结束就买入
            dp[0] = Math.max(dp[0], Math.max(dp[1] - prices[i-1], dp[3] - prices[i-1]));
            // 对于保持卖出可以是前天卖出，也可以是冷冻期刚结束
            dp[1] = Math.max(dp[1], dp[3]);
            // 对于今天卖出只能是前天持有的情况下卖出
            dp[2] = temp + prices[i - 1];
            // 对于冷冻期，只能是卖出转化而来
            dp[3] = temp2;
        }

        return Math.max(dp[1],Math.max(dp[2],dp[3]));
    }
}
