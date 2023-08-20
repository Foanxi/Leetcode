package nowcoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author foanxi
 */
public class BM53 {

    public int minNumberDisappeared(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }
        for (int j = 0; j < nums.length; ++j) {
            if (Math.abs(nums[j]) < nums.length + 1) {
                nums[Math.abs(nums[j]) - 1] = -1 * Math.abs(nums[Math.abs(nums[j]) - 1]);
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        System.out.println(new BM53().minNumberDisappeared(new int[]{-2, 3, 4, 1, 5}));
    }

    public int minNumberDisappeared3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i < nums.length; ++i) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return nums.length - 1;
    }

    public int minNumberDisappeared2(int[] nums) {
        Arrays.sort(nums);
        int cur = 1;
        for (int num : nums) {
            if (num <= 0) {
                continue;
            }
            if (num != cur) {
                return cur;
            }
            cur++;
        }
        return cur;
    }
}
