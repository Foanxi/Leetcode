package middle;

/**
 * @author foanxi
 */
public class T931_minFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        dp[0] = matrix[0];
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (col == 0) {
                    dp[row][col] = Math.min(dp[row - 1][col], dp[row - 1][col + 1]) + matrix[row][col];
                } else if (col == n - 1) {
                    dp[row][col] = Math.min(dp[row - 1][col], dp[row - 1][col - 1]) + matrix[row][col];
                } else {
                    dp[row][col] = Math.min(dp[row - 1][col], Math.min(dp[row - 1][col - 1], dp[row - 1][col + 1])) + matrix[row][col];
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int num : matrix[n - 1]) {
            res = Math.min(res, num);
        }
        return res;
    }
}
