package easy;

/**
 * @author foanxi
 */
public class T26_removeDuplicates {
    public int removeDuplicates(int[] nums) {
        int cur = nums[0];
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[right] == cur) {
                right++;
            } else {
                nums[++left] = nums[right];
                cur = nums[right];
            }
        }
        return left;
    }
}
