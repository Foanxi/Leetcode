package hard;

import java.util.Arrays;

/**
 * @author foanxi
 */
public class T2251_fullBloomFlowers {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < flowers.length; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int[] res = new int[people.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = binarySearch(start, people[i] + 1) - binarySearch(end, people[i]);
        }
        return res;
    }

    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        int res = arr.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid;
            }
        }
        return res;
    }
}
