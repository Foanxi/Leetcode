package middle;

/**
 * @author foanxi
 */
public class T122_maxProfit {
    /**
     * 使用贪心算法，将所有正利润相加即可
     *
     * @param prices 股票价格
     * @return 返回最大收益
     */
    public int maxProfit(int[] prices) {
        int[] profit = new int[prices.length - 1];
        for (int i = 0; i < profit.length; i++) {
            profit[i] = prices[i + 1] - prices[i];
        }
        int total = 0;
        for (int num : profit) {
            if (num > 0) {
                total += num;
            }
        }
        return total;
    }

    /**
     * 使用动态规划
     *
     * @param prices 股票价格
     * @return 返回最大收益
     */
    public int maxProfit2(int[] prices) {
        // dp[i][0]表示持有股票的最大现金，dp[i][1]表示卖出股票后的最大现金
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(prices[i] + dp[i - 1][0], dp[i - 1][1]);
        }

        return dp[prices.length - 1][1];
    }

    /**
     * 使用动态规划+滚动数组
     *
     * @param prices 股票价格
     * @return 返回最大收益
     */
    public int maxProfit3(int[] prices) {
        // dp[0]表示持有股票的最大现金，dp[1]表示卖出股票后的最大现金
        int[] dp = new int[2];
        dp[0] -= prices[0];
        for (int i = 1; i <= prices.length; i++) {
            dp[0] = Math.max(dp[0],dp[1] - prices[i-1]);
            dp[1] = Math.max(dp[1],dp[0] + prices[i-1]);
        }
        return dp[1];
    }
}
