package easy;

public class T392_isSubsequence {
    /**
     * 直接遍历
     *
     * @param s 需要检测的子串
     * @param t 被检测字符串
     * @return 删除部分元素后能否让s为t的子串
     */
    public boolean isSubsequence2(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() < s.length()) {
            return false;
        }
        int lastIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = lastIndex; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    lastIndex = j + 1;
                    break;
                }
                if (j == t.length() - 1) {
                    return false;
                }
            }
            if (lastIndex == t.length() - 1 && i != s.length() - 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        // 从0~i-1为结尾的字符串s，和从0~j-1为结尾的字符串t中相同子序列的长度
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[s.length()][t.length()] == s.length();
    }
}
