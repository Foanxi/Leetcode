package offer2;

import java.util.Arrays;

public class T4 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length-1) {
            if (nums[i] == nums[i + 1]) {
                i += 3;
            } else {
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}
