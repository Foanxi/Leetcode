package middle;

public class T198_rob {
    public int rob(int[] nums) {
        // 0~i间房子内能偷到的最高金额
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i=2;i<=nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i-1],dp[i-1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        new T198_rob().rob(new int[]{2,3,2});
    }
}
