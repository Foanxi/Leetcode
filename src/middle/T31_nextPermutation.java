package middle;

/**
 * @author foanxi
 */
public class T31_nextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 找出左侧第一个非正序的数字
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
            i--;
        }
        if (i < 0){
            reverse(nums,0);
            return;
        }
        // 找到第一个比小数大的数字
        int j = nums.length - 1;
        while (j >= 0) {
            if (nums[j] > nums[i]) {
                break;
            }
            j--;
        }
        swap(nums, i, j);
        int left = i + 1;
        reverse(nums,left);
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void reverse(int[] nums,int left){
        int right = nums.length - 1;
        while (left < right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }
}
