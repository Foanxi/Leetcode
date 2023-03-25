package hard;

public class T72_minDistance {
    public int minDistance(String word1, String word2) {
        // dp[i][j]表示从0~i-1的word1子串和从0~j-1的word2子串最近的标记距离
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 初始化
        for (int i = 0; i < word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    // 替换一个元素
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1,
                            // 删除一个元素 = 添加一个元素
                            Math.min(dp[i][j - 1], dp[i - 1][j]));

                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
