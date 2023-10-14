package middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author foanxi
 */
public class T137_singleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue() == 1) {
                return integerIntegerEntry.getKey();
            }
        }
        return -1;
    }
}
