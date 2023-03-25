package easy;

import java.util.Arrays;

public class T2389_answerQueries {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] res = new int[queries.length];
        int[] map = new int[nums.length];
        Arrays.sort(nums);
        map[0] = nums[0];
        for (int i = 1; i < map.length; i++) {
            map[i] = map[i - 1] + nums[i];
        }
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] < map[0]) {
                queries[i] = 0;
            } else {
                res[i] = binarySearch(map, queries[i]) + 1;
            }
        }
        return res;
    }

    public int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (arr[mid] < target && arr[mid + 1] <= target) {
                l = mid + 1;
            } else if (arr[mid] == target || (arr[mid] < target && arr[mid + 1] > target)) {
                return mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}
