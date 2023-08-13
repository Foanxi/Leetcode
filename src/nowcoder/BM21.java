package nowcoder;

public class BM21 {
    public int minNumberInRotateArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new BM21().minNumberInRotateArray(new int[]{3, 100, 200, 3}));
    }
}
