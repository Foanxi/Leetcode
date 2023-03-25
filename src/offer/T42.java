package offer;

public class T42 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int cur = 0;
        for (int num : nums) {
            cur += num;
            max = Math.max(max, cur);
            if (cur < 0) {
                cur = 0;
            }
        }
        return max;
    }
}
