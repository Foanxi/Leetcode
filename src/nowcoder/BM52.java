package nowcoder;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author foanxi
 */
public class BM52 {
    public int[] FindNumsAppearOnce(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        ArrayList<Integer> integers = new ArrayList<>(set);
        return new int[]{integers.get(0), integers.get(1)};
    }
}
