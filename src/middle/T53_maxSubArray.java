package middle;

/**
 * @author foanxi
 */
public class T53_maxSubArray {
    /**
     * 动态规划
     *
     * @param nums 数组
     * @return 连续子数组最大和
     */
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        // dp[i]表示从0到i的最大值
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], 0);
            if (dp[i] > result){
                result = dp[i];
            }
        }
        return result;
    }

    /**
     * 贪心算法
     *
     * @param nums 数组
     * @return 连续子数组最大和
     */
    public int maxSubArray2(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int num : nums) {
            count += num;
            if (count > result) {
                result = count;
            }
            if (count + num <= 0) {
                count = 0;
            }
        }
        return result;
    }
}
