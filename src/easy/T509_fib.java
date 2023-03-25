package easy;

public class T509_fib {
    /**
     * 递归方法
     *
     * @param n 要求的斐波那契数
     * @return 返回f(n)
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public int fib2(int n) {
        if (n==0 || n==1){
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
