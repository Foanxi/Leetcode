package middle;

public class T474_findMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j]表示最多有i个0和j个1的情况下子集的长度
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeroNum = 0;
            int oneNum = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }

            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    // 放入当前这个子集，因此自己长度加1
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
