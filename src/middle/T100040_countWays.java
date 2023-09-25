package middle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author foanxi
 */
public class T100040_countWays {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int res = 0;
        int cur = 0;
        if (nums.get(0) != 0) {
            res++;
        }
        for (int i = 0; i < nums.size() - 1; i++) {
            if (i + 1 > nums.get(i) && nums.get(i + 1) > i + 1) {
                res++;
            }
        }
        if (nums.get(nums.size() - 1) < nums.size()) {
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new middle.T100040_countWays().countWays(Arrays.asList(0,1,1,1)));
        System.out.println(new T100040_countWays().countWays(Arrays.asList(6, 0, 3, 3, 6, 7, 2, 7)));
    }
}
