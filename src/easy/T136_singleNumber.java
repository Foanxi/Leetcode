package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author foanxi
 */
public class T136_singleNumber {
    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int res = 0;
        for (int num : set) {
            res = num;
        }
        return res;
    }

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
