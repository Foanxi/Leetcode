package middle;

import java.util.Arrays;

public class T322_coinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        // 凑成数额为i的硬币最少需要dp[i]个
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                if (dp[j - coin] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new T322_coinChange().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new T322_coinChange().coinChange(new int[]{2}, 3));
    }
}
