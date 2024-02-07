package middle;

import java.util.PriorityQueue;
import java.util.Queue;

public class T1696_maxResult {
    public int maxResult(int[] nums, int k) {
        // 对于当前位置在i的时候，最大得分为从[i-k,i-1]中最大的得分
        int len = nums.length;
        int[] dp = new int[len];
        // dp[i] = Math.max(dp[i - 1],max) + dp[i];
        dp[0] = nums[0];
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        queue.add(new int[]{0, dp[0]});
        for (int i = 1; i < len; i++) {
            int max = dp[i - 1];
            while (!queue.isEmpty()) {
                int[] poll = queue.peek();
                if (poll[0] >= i - k) {
                    max = poll[1];
                    break;
                } else {
                    queue.poll();
                }
            }
            dp[i] = max + nums[i];
            queue.add(new int[]{i, dp[i]});
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(new T1696_maxResult().maxResult(new int[]{10, -5, -2, 4, 0, 3}, 3));
    }
}
