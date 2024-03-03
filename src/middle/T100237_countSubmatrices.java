package middle;

public class T100237_countSubmatrices {
    public int countSubmatrices(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + grid[i][j] - dp[i - 1][j - 1];
            }
        }
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dp[i][j] <= k) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{7, 2, 9}, {1, 5, 0}, {2, 6, 6}};
        System.out.println(new T100237_countSubmatrices().countSubmatrices(grid, 20));
    }
}
