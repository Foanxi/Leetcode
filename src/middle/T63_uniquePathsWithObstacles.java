package middle;

public class T63_uniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 && j >= 1) {
                    dp[i][j] = Math.min(1, dp[i][j - 1]);
                } else if (j == 0 && i >= 1) {
                    dp[i][j] = Math.min(1, dp[i - 1][j]);
                } else if (i == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        System.out.println(new T63_uniquePathsWithObstacles().uniquePathsWithObstacles(new int[][]{{0, 0}, {1, 1}, {0, 0}}));
    }
}
