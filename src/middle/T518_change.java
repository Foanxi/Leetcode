package middle;

public class T518_change {
    public int change(int amount, int[] coins) {
        // 使用coins内的硬币凑出金额为i的方法有dp[i]种
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new T518_change().change(5, new int[]{1, 2, 5}));
    }
}
