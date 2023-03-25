package middle;

public class T516_longestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        // dp[i][j]表示从i到j的范围内回文子序列的最大长度
        int[][] dp = new int[s.length()][s.length()];
        // 初始化，当i和j相等时为1
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
