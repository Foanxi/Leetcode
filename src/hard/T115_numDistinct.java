package hard;

/**
 * @author foanxi
 */
public class T115_numDistinct {
    public int numDistinct(String s, String t) {
        // dp[i][j]表示0~i-1范围的字串中，以j-1为结尾的t的个数
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        // 初始化，代表从0到i-1的s子串至少可以得到一个空字符串
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                // 如果s[i-1] == t[j-1]，则可以选择使用s[i-1]匹配或者不使用
                // 如果使用则个数为dp[i-1][j-1]，如果不用则个数为dp[i-1][j]
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }
        return dp[s.length()][t.length()];
    }
}
