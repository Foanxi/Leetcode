package middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author foanxi
 */
public class T260_singleNumber {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue() == 1) {
                res[index++] = integerIntegerEntry.getKey();
            }
            if (index >= 2) {
                break;
            }
        }
        return res;
    }
}
