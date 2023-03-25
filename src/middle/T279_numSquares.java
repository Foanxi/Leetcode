package middle;

import java.util.Arrays;

public class T279_numSquares {
    public int numSquares(int n) {
        // 表示凑成i的个数为dp[i]
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 0; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new T279_numSquares().numSquares(13));
    }
}
