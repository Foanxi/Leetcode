package hard;

public class T123_maxProfit {
    public int maxProfit(int[] prices) {
        // dp[i][j]表示第i天第j种状态下所剩下的最大现金
        // j = 0表示当前不做任何操作
        // j = 1表示第一次持有股票
        // j = 2表示第一次卖出股票
        // j = 3表示第二次持有股票
        // j = 4表示第二次卖出股票
        int[][] dp = new int[prices.length][5];
        dp[0][1] -= prices[0];
        dp[0][3] -= prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 当前既可以买入股票或者持有前天的股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 当前卖出股票或者沿用当前状态
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
            // 同理可得
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][3] + prices[i], dp[i - 1][4]);
        }
        return dp[prices.length - 1][4];
    }

    /**
     * 滚动数组
     * @param prices 股票价格数组
     * @return 返回最多可以赚取的利润
     */
    public int maxProfit2(int[] prices) {
        // dp[i]表示第j种状态下所剩下的最大现金
        // j = 0表示当前不做任何操作
        // j = 1表示第一次持有股票
        // j = 2表示第一次卖出股票
        // j = 3表示第二次持有股票
        // j = 4表示第二次卖出股票
        int[] dp = new int[5];
        dp[1] -= prices[0];
        dp[3] -= prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 当前既可以买入股票或者持有前天的股票
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
            // 当前卖出股票或者沿用当前状态
            dp[2] = Math.max(dp[1] + prices[i], dp[2]);
            // 同理可得
            dp[3] = Math.max(dp[3], dp[2] - prices[i]);
            dp[4] = Math.max(dp[3] + prices[i], dp[4]);
        }
        return dp[4];
    }
}
