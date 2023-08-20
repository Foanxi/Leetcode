package middle;

public class T740_deleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        // 构造新的数组
        int maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }
        int[] newNums = new int[maxValue + 1];
        for (int num : nums) {
            newNums[num] += num;
        }
        if (newNums.length == 1) {
            return newNums[0];
        }
        int[] dp = new int[newNums.length];
        dp[0] = newNums[0];
        dp[1] = Math.max(newNums[1], newNums[0]);
        for (int i = 2; i < newNums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + newNums[i]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new T740_deleteAndEarn().deleteAndEarn(new int[]{3, 1}));
    }
}
