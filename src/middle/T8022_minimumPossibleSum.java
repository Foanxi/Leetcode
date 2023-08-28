package middle;

import java.util.HashSet;
import java.util.Set;

/**
 * @author foanxi
 */
public class T8022_minimumPossibleSum {
    public long minimumPossibleSum(int n, int target) {
        int[] nums = new int[n];
        int cur = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            while (set.contains(cur)) {
                cur++;
            }
            nums[i] = cur;
            set.add(cur);
            set.add(target - cur);
        }
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
