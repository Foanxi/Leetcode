package middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author foanxi
 */
public class T1488_avoidFlood {
    public int[] avoidFlood(int[] rains) {
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = rains.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                set.add(i);
            } else {
                res[i] = -1;
                if (map.containsKey(rains[i])) {
                    Integer ceiling = set.ceiling(map.get(rains[i]));
                    if (ceiling == null) {
                        return new int[0];
                    }
                    res[ceiling] = rains[i];
                    set.remove(ceiling);
                }
                map.put(rains[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 0, 0, 2, 1};
        System.out.println(Arrays.toString(new T1488_avoidFlood().avoidFlood(num)));
    }
}
