package middle;

public class T162_findPeakElement {
    public static void main(String[] args) {
        System.out.println(new T162_findPeakElement().findPeakElement(new int[]{1, 2}));
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        return binarySearch(nums, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int left, int right) {
        int mid = (right - left) / 2 + left;
        if (left > right) {
            return -1;
        }
        if (mid == 0 && nums[mid] > nums[mid + 1]) {
            return mid;
        } else if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) {
            return mid;
        }
        if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
            return mid;
        } else {
            int leftFind = binarySearch(nums, left, mid - 1);
            if (leftFind != -1) {
                return leftFind;
            }
            return binarySearch(nums, mid + 1, right);
        }
    }
}
