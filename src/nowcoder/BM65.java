package nowcoder;

/**
 * @author foanxi
 */
public class BM65 {
    public String LCS(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        // dp[i][j]表示s1在[0,i-1]内和s2在[0,j-1]内最长长度
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = dp.length - 1;
        int j = dp[0].length - 1;
        while (dp[i][j] != 0) {
            // 来自上边
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            }
            // 来自左边
            else if (dp[i][j] == dp[i][j - 1]) {
                j--;
            } else if (dp[i][j] > dp[i - 1][j - 1]) {
                i--;
                j--;
                sb.append(s1.charAt(i));
            }
        }
        return sb.length() == 0 ? "-1" : sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new BM65().LCS("1A2C3D4B56", "B1D23A456A"));
    }
}
