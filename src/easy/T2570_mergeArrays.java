package easy;

import java.util.Map;
import java.util.TreeMap;

public class T2570_mergeArrays {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] num : nums1) {
            map.put(num[0], num[1]);
        }

        for (int[] num : nums2) {
            if (map.containsKey(num[0])) {
                map.put(num[0], num[1] + map.get(num[0]));
            } else {
                map.put(num[0], num[1]);
            }
        }
        int[][] result = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[i] = new int[]{entry.getKey(), entry.getValue()};
            i++;
        }
        return result;
    }
}
