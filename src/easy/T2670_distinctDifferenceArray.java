package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T2670_distinctDifferenceArray {
    public int[] distinctDifferenceArray(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len + 1];
        Set<Integer> leftSet = new HashSet<>();
        Set<Integer> rightSet = new HashSet<>();
        for (int i = 0, j = len - 1; i < len; i++, j--) {
            leftSet.add(nums[i]);
            rightSet.add(nums[j]);
            left[i] = leftSet.size();
            right[j] = rightSet.size();
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = left[i] - right[i + 1];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T2670_distinctDifferenceArray().distinctDifferenceArray(new int[]{1, 2, 3, 4, 5})));
    }
}
