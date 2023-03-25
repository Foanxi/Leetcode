package offer;

public class T14_1 {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i],Math.max(dp[i - j] * j, j * (i - j)));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new T14_1().cuttingRope(10));
    }
}
