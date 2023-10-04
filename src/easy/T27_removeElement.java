package easy;

/**
 * @author foanxi
 */
public class T27_removeElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 1) {
            return nums[0] == val ? 0 : 1;
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int len = new T27_removeElement().removeElement(nums, 3);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
