package middle;

/**
 * @author foanxi
 */
public class T712_minimumDeleteSum {
    public int minimumDeleteSum(String s1, String s2) {
        // dp[i][j]表示[0,i-1]的s1和[0,j-1]的s2之间的最小删除和
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        // 初始化dp[i][0]和dp[0][j]
        // 此时等于删除所有，因此直接初始化为对应的ASCII码的和
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
