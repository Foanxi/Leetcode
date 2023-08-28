package nowcoder;

/**
 * @author foanxi
 */
public class BM63 {
    public int jumpFloor(int number) {
        if (number == 1) {
            return 1;
        } else if (number == 2) {
            return 2;
        }
        int[] dp = new int[number];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < number; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[number - 1];
    }
}
