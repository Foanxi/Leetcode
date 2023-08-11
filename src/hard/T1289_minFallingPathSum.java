package hard;

import java.util.Arrays;

public class T1289_minFallingPathSum {
    public int minFallingPathSum(int[][] grid) {
        int res = Integer.MAX_VALUE;
        int n = grid.length;
        int[][] dp = new int[n][n];
        System.arraycopy(grid[0], 0, dp[0], 0, n);
        // i控制行,j控制列,k控制上一层循环
        for (int i = 1; i < n; i++) {
            Arrays.fill(dp[i], 100);
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (k == j) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + grid[i][j]);
                }
            }
        }
        for (int num : dp[n - 1]) {
            res = Math.min(res, num);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new T1289_minFallingPathSum().minFallingPathSum(grid));
    }
}
