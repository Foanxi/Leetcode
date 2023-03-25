package offer;

public class T53_1 {
    public int search(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        if (left <= right && right < nums.length && nums[left] == target && nums[right] == target) {
            return right - left + 1;
        }
        return 0;
    }

    public int binarySearch(int[] arr, int target, boolean lower) {
        int left = 0, right = arr.length - 1, index = arr.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target || (lower && arr[mid] >= target)) {
                right = mid - 1;
                index = mid;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    public int search2(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }
}
