package middle;

import java.util.HashMap;
import java.util.Map;

public class T447_numberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        if (len < 3) {
            return 0;
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                int distance = (int) (Math.pow(points[j][1] - points[i][1], 2) + Math.pow(points[j][0] - points[i][0], 2));
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() >= 2) {
                    res += entry.getValue() * (entry.getValue() - 1) / 2;
                }
            }
            map.clear();
        }
        return res * 2;
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        System.out.println(new T447_numberOfBoomerangs().numberOfBoomerangs(points));
    }
}
