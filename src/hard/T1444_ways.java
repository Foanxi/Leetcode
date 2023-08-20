package hard;

public class T1444_ways {
    public int ways(String[] pizza, int k) {
        int m = pizza.length, n = pizza[0].length(), mod = 1_000_000_007;
        // apples[i][j]表示在坐标(i,j)处右下角的苹果数量
        int[][] apples = new int[m + 1][n + 1];
        int[][][] dp = new int[k + 1][m + 1][n + 1];
        // 首先统计右下角苹果数量以及预处理dp为1的情况
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                apples[i][j] = (pizza[i].charAt(j) == 'A' ? 1 : 0) + apples[i + 1][j] + apples[i][j + 1] - apples[i + 1][j + 1];
                dp[1][i][j] = apples[i][j] > 0 ? 1 : 0;
            }
        }
        for (int ki = 2; ki <= k; ki++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 水平切
                    for (int i1 = i + 1; i1 < m; i1++) {
                        if (apples[i][j] > apples[i1][j]) {
                            dp[ki][i][j] = (dp[ki][i][j] + dp[ki - 1][i1][j]) % mod;
                        }
                    }
                    for (int j1 = j + 1; j1 < n; j1++) {
                        if (apples[i][j] > apples[i][j1]) {
                            dp[ki][i][j] = (dp[ki][i][j] + dp[ki - 1][i][j1]) % mod;
                        }
                    }
                }
            }
        }
        return dp[k][0][0];
    }
}
