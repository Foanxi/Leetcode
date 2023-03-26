package hard;

public class T188_maxProfit {
    public int maxProfit(int k, int[] prices) {
        // dp[i]表示第j种状态下所剩下的最大现金
        // j为奇数表示持有股票
        // j为偶数表示卖出股票
        int[] dp = new int[k * 2 + 1];
        for (int j = 1; j <= 2 * k; j += 2) {
            dp[j] -= prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k * 2; j++) {
                int sym = j % 2 == 0 ? 1 : -1;
                dp[j] = Math.max(dp[j], dp[j - 1] + prices[i] * sym);
            }
        }
        return dp[2 * k];
    }
}
