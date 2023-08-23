package middle;

public class T1140_stoneGameII {
    public int stoneGameII(int[] piles) {
        // dp[i][j]表示从i~最后一堆，最多可以取2j的情况下，先取的人最多可获得石头
        int[][] dp = new int[piles.length][piles.length - 1];
        int sum = 0;
        for (int i = piles.length - 1; i >= 0; i--) {
            sum += piles[i];
            for (int m = 1; m < piles.length; m++) {
                if (i + 2 * m > piles.length) {
                    dp[i][m] = sum;
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        dp[i][m] = Math.max(dp[i][m], sum - dp[i + x][Math.max(x, m)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}
