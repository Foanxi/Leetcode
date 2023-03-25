package middle;

public class T1139_largest1BorderedSquare {
    public int largest1BorderedSquare(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        // dp[i][j][0]表示坐标为(i,j)的位置左边横向连续1的个数和上边连续1的个数
        int[][][] dp = new int[row + 1][col + 1][2];
        int result = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (grid[i - 1][j - 1] != 0) {
                    dp[i][j][0] = dp[i][j - 1][0] + 1;
                    dp[i][j][1] = dp[i - 1][j][1] + 1;
                }
            }
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                int curSide = Math.min(dp[i][j][0], dp[i][j][1]);
                while (curSide > result) {
                    if (dp[i - curSide + 1][j][0] >= curSide && dp[i][j - curSide + 1][1] >= curSide) {
                        result = curSide;
                        break;
                    }
                    curSide--;
                }
            }
        }

        return result*result;
    }
}
