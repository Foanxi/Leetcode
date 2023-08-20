package hard;

/**
 * @author foanxi
 */
public class T1388_maxSizeSlices {
    public int maxSizeSlices(int[] slices) {
        int res1 = dp(slices, 0, slices.length - 2);
        int res2 = dp(slices, 1, slices.length - 1);
        return Math.max(res1, res2);
    }

    public int dp(int[] slices, int start, int end) {
        int k = slices.length / 3;
        // dp[i][k]表示取第i位时已经取了k块的情况
        int[][] dp = new int[slices.length + 1][k + 1];
        dp[start][1] = slices[start];
        dp[start + 1][1] = Math.max(slices[start], slices[start + 1]);
        for (int i = 2; i <= end; i++) {
            // 遍历从第i位
            for (int j = 1; j <= Math.min(k, i); j++) {
                dp[i][j] = Math.max(dp[i - 2][j - 1] + slices[i], dp[i - 1][j]);
            }
        }
        return dp[end][k];
    }

    public static void main(String[] args) {
        System.out.println(new T1388_maxSizeSlices().maxSizeSlices(new int[]{8, 9, 8, 6, 1, 1}));
    }
}
