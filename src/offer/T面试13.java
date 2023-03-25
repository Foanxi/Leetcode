package offer;

public class T面试13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] dp = new boolean[m][n];
        int res = 1;
        dp[0][0] = true;
        for (int row = 0; row < m; ++row) {
            for (int col = 0; col < n; ++col) {
                if ((row == 0 && col == 0) || getNum(row) + getNum(col) > k) {
                    continue;
                }
                if (row > 0) {
                    dp[row][col] |= dp[row - 1][col];
                }
                if (col > 0) {
                    dp[row][col] |= dp[row][col - 1];
                }
                res += dp[row][col] ? 1 : 0;
            }
        }
        return res;
    }

    public int getNum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
