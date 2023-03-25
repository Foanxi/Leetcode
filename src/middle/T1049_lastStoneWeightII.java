package middle;

import java.util.Arrays;

public class T1049_lastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        Arrays.sort(stones);
        int sum = 0;
        for (int num : stones) {
            sum += num;
        }
        int[] dp = new int[sum / 2 + 1];
        for (int num : stones) {
            for (int j = sum / 2; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
            if (dp[sum / 2] == sum / 2) {
                break;
            }
        }
        return sum -dp[sum/2] - dp[sum / 2];
    }

    public static void main(String[] args) {
        System.out.println(new T1049_lastStoneWeightII().lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
    }
}
