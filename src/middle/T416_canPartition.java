package middle;

public class T416_canPartition {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int[] dp = new int[sum / 2 + 1];
        for (int num : nums) {
            for (int j = sum / 2; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
            if (dp[sum / 2] == sum / 2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new T416_canPartition().canPartition(new int[]{1, 2, 3, 5}));
    }
}
