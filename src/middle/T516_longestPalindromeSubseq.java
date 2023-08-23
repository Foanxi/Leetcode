package middle;

/**
 * @author foanxi
 */
public class T516_longestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] charArray = s.toCharArray();
        // dp[i][j]表示从[i,j]范围内最长回文串的长度
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (charArray[i] == charArray[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
