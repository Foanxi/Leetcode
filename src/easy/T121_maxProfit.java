package easy;

public class T121_maxProfit {
    public int maxProfit(int[] prices) {
        // 第i天获得利润的为dp[i]
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            max = Math.max(prices[i] - min,max);
        }
        return max;
    }
}
