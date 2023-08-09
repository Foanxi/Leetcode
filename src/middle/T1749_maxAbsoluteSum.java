package middle;

/**
 * @author foanxi
 */
public class T1749_maxAbsoluteSum {
    public int maxAbsoluteSum(int[] nums) {
        // dp[i][0]表示到i位的最小值
        // dp[i][1]表示到i位的最大值
        int dpMax = nums[0];
        int dpMin = nums[0];
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            dpMin = Math.min(dpMin + nums[i], nums[i]);
            if (dpMin < min) {
                min = dpMin;
            }
            dpMax = Math.max(dpMax + nums[i], nums[i]);
            if (dpMax > max) {
                max = dpMax;
            }
        }
        return Math.max(Math.abs(min), max);
    }

    public static void main(String[] args) {
        System.out.println(new T1749_maxAbsoluteSum().maxAbsoluteSum(new int[]{2, -1}));
    }
}
