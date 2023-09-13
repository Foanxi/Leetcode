package easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author foanxi
 */
public class T8029_numberOfPoints {
    public int numberOfPoints(List<List<Integer>> nums) {
        Set<Integer> set = new HashSet<>();
        for (List<Integer> list : nums) {
            for (int j = list.get(0); j <= list.get(list.size() - 1); j++) {
                set.add(j);
            }
        }
        return set.size();
    }
}
