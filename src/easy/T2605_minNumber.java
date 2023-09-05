package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author foanxi
 */
public class T2605_minNumber {
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        for (int j : nums1) {
            set.add(j);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                return i;
            }
        }
        int num1 = Math.min(nums1[0], nums2[0]);
        int num2 = Math.max(nums1[0], nums2[0]);
        return num1 * 10 + num2;
    }
}
