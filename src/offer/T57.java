package offer;

public class T57 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < nums.length) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return null;
    }
}
