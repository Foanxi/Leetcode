package offer;

public class T10_2 {
    public int numWays(int n) {
        if (n<2){
            return 1;
        }
        final int mod = 1000000007;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2;i<=n;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % mod;
        }
        return dp[n];
    }
}
