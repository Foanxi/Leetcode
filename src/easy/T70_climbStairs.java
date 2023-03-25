package easy;

/**
 * @author foanxi
 */
public class T70_climbStairs {
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        // 用于表示爬到第i层有dp[i]种方法
        int[] dp = new int[n + 1];
        // 爬到第一层台阶有一种方法
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new T70_climbStairs().climbStairs(5));
    }
}
