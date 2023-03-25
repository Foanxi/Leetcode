package middle;

public class T494_findTargetSumWays {
    /**
     * 求nums中随机加减数字最终可以凑成target的组合的个数
     * 理论基础，设负数总和为neg，则整数位sum-neg
     * target = sum-neg-neg => neg = (sum-target)/2
     *
     * @param nums   元素
     * @param target 需要凑成的数字和
     * @return 返回组合个数
     */
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff == 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg; j >= num; j--) {
                if (j > num) {
                    dp[j] += dp[j - num];
                }
            }
        }
        return dp[neg];
    }
}
