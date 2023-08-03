package hard;

import java.util.Arrays;

public class T2681_sumOfPower {
    public int sumOfPower(int[] nums) {
        int res = 0, mod = 1000000007;
        // dp[i]表示当前以nums[i]结尾的最小数之和
        int[] dp = new int[nums.length];
        int pre = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            int x = nums[i];
            dp[i] = (x + pre) % mod;
            pre = (pre + dp[i]) % mod;
            res = (int) ((res + (long) x * x % mod * dp[i]) % mod);
            if (res < 0) {
                res += mod;
            }
        }
        return res;
    }

    public int sumOfPower2(int[] nums) {
        long fin = 0L;
        int mod = 1000000007;
        long[] dp = new long[nums.length];
        long[] pre = new long[nums.length];
        Arrays.sort(nums);
        dp[0] = nums[0];
        pre[0] = nums[0];
        fin = dp[0] * dp[0] % mod * dp[0] % mod;
        for (int n = 1; n < nums.length; n++) {
            dp[n] = (nums[n] + pre[n - 1]) % mod;
            long now = ((long) nums[n] * (long) nums[n]) % mod;
            fin = (fin + (dp[n] * now) % mod) % mod;
            pre[n] = (dp[n] + pre[n - 1]) % mod;
        }
        return (int) (fin % mod);
    }
}
