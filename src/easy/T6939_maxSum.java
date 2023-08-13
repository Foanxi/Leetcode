package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author foanxi
 */
public class T6939_maxSum {
    public int maxSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int j : nums) {
            int max = 0;
            int num = j;
            while (num > 0) {
                max = Math.max(max, num % 10);
                num /= 10;
            }
            List<Integer> list;
            if (map.containsKey(max)) {
                list = map.get(max);
            } else {
                list = new ArrayList<>();
            }
            list.add(j);
            map.put(max, list);
        }
        int max = Integer.MIN_VALUE;
        for (int i : map.keySet()) {
            List<Integer> list = map.get(i);
            if (list.size() < 2) {
                continue;
            }
            list.sort(((o1, o2) -> o2 - o1));
            max = Math.max(max, list.get(0) + list.get(1));
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }

    public static void main(String[] args) {
        System.out.println(new T6939_maxSum().maxSum(new int[]{51, 71, 17, 24, 42}));
    }
}
