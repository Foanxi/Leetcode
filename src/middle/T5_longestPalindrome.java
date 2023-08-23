package middle;

/**
 * @author foanxi
 */
public class T5_longestPalindrome {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }
        int len = s.length();
        int res = 0;
        String maxString = "";
        // dp[i][j]表示从i到j是否能够构成回文字符串
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 初始化dp
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                    if (dp[i][j] && j - i > res) {
                        res = j - i;
                        maxString = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res == 0 ? String.valueOf(s.charAt(0)) : maxString;
    }

    public static void main(String[] args) {
        System.out.println(new T5_longestPalindrome().longestPalindrome("bb"));
    }
}
