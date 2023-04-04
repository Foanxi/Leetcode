package middle;

public class T5_longestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length()==0){
            return "";
        }
        // dp[i][j]表示s字符串的
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 初始化，当前自己本身一定是回文串
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        int maxLen = 0;
        String maxString = "";

        for (int i = s.length() - 1; i >= 0; --i) {
            for (int j = i; j < s.length(); ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        if (j - i > maxLen) {
                            maxLen = j - i;
                            maxString = s.substring(i, j + 1);
                        }
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (j - i > maxLen) {
                            maxLen = j - i;
                            maxString = s.substring(i, j + 1);
                        }
                    }
                }
            }
        }
        return maxLen == 0? String.valueOf(s.charAt(0)) :maxString;
    }
}
