package easy;


/**
 * @author foanxi
 */
public class T746_minCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        // 对于一个数组[10,15,20]可以理解为[0,10,15,20]的一个数组
        // 因为一开始出发是不需要体力的
        if (cost.length < 2) {
            return cost[cost.length - 1];
        }
        // 创建dp数组表示爬升到第i+1个台阶所需要花费的最小体力
        // 设置dp数组比原本cost数组长一个长度用于保存楼顶
        int[] dp = new int[cost.length + 1];
        // 无论是爬升到第1个还是第2个都是花费0体力
        dp[0] = 0;
        dp[1] = 0;
        // 注意是<=，因为需要爬升到楼顶
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
