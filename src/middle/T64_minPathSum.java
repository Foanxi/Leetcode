package middle;

/**
 * @author foanxi
 */
public class T64_minPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        // 初始化行
        dp[0][0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int j = 1; j < row; j++) {
            dp[j][0] = grid[j][0] + dp[j - 1][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new T64_minPathSum().minPathSum(grid));
    }
}
