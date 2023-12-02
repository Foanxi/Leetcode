package middle;

import java.util.*;

public class T1094_carPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        int toMax = 0;
        for (int[] trip : trips) {
            toMax = Math.max(toMax, trip[2]);
        }

        int[] diff = new int[toMax + 1];
        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }

        int count = 0;
        for (int i = 0; i <= toMax; ++i) {
            count += diff[i];
            if (count > capacity) {
                return false;
            }
        }
        return true;
    }

    public boolean carPooling2(int[][] trips, int capacity) {
        Arrays.sort(trips, (o1, o2) -> o1[2] - o2[2]);
        Map<Integer, List<int[]>> on = new HashMap<>();
        for (int[] trip : trips) {
            List<int[]> orDefault = on.getOrDefault(trip[1], new ArrayList<>());
            orDefault.add(trip);
            on.put(trip[1], orDefault);
        }
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        Map<Integer, List<Integer>> map = new HashMap<>();
        int cur = 0;
        for (int i = 0; i < trips[trips.length - 1][2]; i++) {
            // 判断当前这个位置有没有人下车
            while (!queue.isEmpty() && queue.peek() == i) {
                for (int num : map.get(queue.poll())) {
                    cur -= num;
                }
            }
            // 检查当前位置有没有人上车
            if (on.containsKey(i)) {
                List<int[]> ints = on.get(i);
                for (int[] list : ints) {
                    int num = list[0];
                    int down = list[2];
                    if (cur + num <= capacity) {
                        cur += num;
                        if (!queue.contains(down)) {
                            queue.add(down);
                        }
                        List<Integer> orDefault = map.getOrDefault(down, new ArrayList<>());
                        orDefault.add(num);
                        map.put(down, orDefault);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] mat = {{3, 3, 5}, {4, 5, 6}, {1, 2, 7}, {3, 2, 8}, {10, 5, 9}, {2, 5, 9}, {1, 2, 5}};
        System.out.println(new T1094_carPooling().carPooling(mat, 19));
    }
}
