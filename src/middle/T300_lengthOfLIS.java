package middle;

import java.util.Arrays;

public class T300_lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int result = 0;
        // dp[i]表示从0到i的最长子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            if (result < dp[i]) {
                result = dp[i];
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new T300_lengthOfLIS().lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
    }
}
