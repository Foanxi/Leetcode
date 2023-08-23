package middle;

/**
 * @author foanxi
 */
public class T221_maximalSquare {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] - '0' == 1) {
                dp[i][0] = matrix[i][0] - '0';
                res = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] - '0' == 1) {
                dp[0][i] = matrix[0][i] - '0';
                res = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    res = Math.max(dp[i][j], res);
                }
            }
        }
        return res * res;
    }

    public static void main(String[] args) {
        char[][] chars = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(new T221_maximalSquare().maximalSquare(chars));
    }
}
