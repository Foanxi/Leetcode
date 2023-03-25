package easy;

import java.util.Arrays;

/**
 * @author foanxi
 */
public class T1005_largestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; k > 0 && i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        if (k % 2 == 0) {
            return getSum(nums);
        }
        Arrays.sort(nums);
        nums[0] = -nums[0];
        return getSum(nums);
    }

    public int getSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

}
