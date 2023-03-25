package middle;

/**
 * @author foanxi
 */
public class T714_maxProfit {

    /**
     * 动态规划
     *
     * @param prices 股票价格
     * @param fee    手续费
     * @return 能够获取到最大利润
     */
    public int maxProfit(int[] prices, int fee) {
        // 第i天的利润最大利润为dp[i]
        // dp[i][0]表示持有股票,dp[i][1]表示卖出股票
        int[] dp = new int[2];
        dp[0] -= prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1] - prices[i]);
            dp[1] = Math.max(dp[0] + prices[i] - fee, dp[1]);
        }
        return dp[1];
    }

    /**
     * 贪心算法
     *
     * @param prices 股票价格
     * @param fee    手续费
     * @return 能够获取到最大利润
     */
    public int maxProfit2(int[] prices, int fee) {
        int result = 0;
        int minPrice = prices[0] + fee;
        for (int i = 1; i < prices.length; i++) {
            // 如果当前这个股票的买入价格比之前的还便宜，就买入
            if (prices[i] + fee < minPrice) {
                minPrice = prices[i] + fee;
            }

            // 如果当前这个股票价格卖出后能有盈余，则将其假设卖出
            if (prices[i] > minPrice) {
                result += prices[i] - minPrice;
                // 一个反悔操作，如果新的一天卖出价格更加值得，则我们按照新的一天卖出时相互抵消
                // => newDayPrice - nowPrice + nowPrice - minPrice
                // => newDayPrice - minPrice
                minPrice = prices[i];
            }

            // 还有一种情况是既不值得买入，也不值得卖出
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new T714_maxProfit().maxProfit2(new int[]{1, 3, 7, 5, 10, 3}, 3));
        System.out.println(new T714_maxProfit().maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }
}
