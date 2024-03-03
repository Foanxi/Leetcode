package middle;

public class T2369_validPartition {
    public boolean validPartition(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        dp[1] = nums[0] == nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (dp[i - 2] && nums[i] == nums[i - 1]) {
                dp[i] = true;
            } else if (i >= 3 && dp[i - 3] && check3(nums, i)) {
                dp[i] = true;
            }
        }
        return dp[nums.length - 1];
    }

    public boolean check3(int[] nums, int cur) {
        return (nums[cur] == nums[cur - 1] && nums[cur - 2] == nums[cur]) || (nums[cur - 1] + 1 == nums[cur] && nums[cur - 2] + 1 == nums[cur - 1]);
    }

    public boolean validPartition2(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            if (i >= 2) {
                dp[i] = dp[i - 2] && validTwo(nums[i - 2], nums[i - 1]);
            }
            if (i >= 3) {
                dp[i] = dp[i] || (dp[i - 3] && validThree(nums[i - 3], nums[i - 2], nums[i - 1]));
            }
        }
        return dp[n];
    }

    public boolean validTwo(int num1, int num2) {
        return num1 == num2;
    }

    public boolean validThree(int num1, int num2, int num3) {
        return (num1 == num2 && num1 == num3) || (num1 + 1 == num2 && num2 + 1 == num3);
    }

    public static void main(String[] args) {
        System.out.println(new T2369_validPartition().validPartition2(new int[]{993335,993336,993337,993338,993339,993340,993341}));
    }
}
