package middle;

public class T213_rob {
    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        return Math.max(rob2(0, nums), rob2(1, nums));
    }

    public int rob2(int start, int[] nums) {
        // 0~i间房子内能偷到的最高金额
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[start];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1 + start], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new T213_rob().rob(new int[]{1, 2, 3, 1}));
    }
}
