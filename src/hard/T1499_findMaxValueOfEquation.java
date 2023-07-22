package hard;

import java.util.PriorityQueue;

/**
 * @author hujinxu
 */
public class T1499_findMaxValueOfEquation {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int max = Integer.MIN_VALUE;
        int[] last = {points[0][0], points[0][1]};
        for (int i = 0; i < points.length; ++i) {
            for (int j = i + 1; j < points.length && points[j][0] - points[i][0] <= k; ++j) {
                if (last[0] - last[1] > points[j][0] - points[j][1]) {
                    last = points[j];
                }
                max = Math.max(points[j][0] + points[j][1] - last[0] + last[1], max);
            }
        }
        return max;
    }

    public int findMaxValueOfEquation2(int[][] points, int k) {
        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int[] m : points) {
            while (!queue.isEmpty() && m[0] - queue.peek()[1] > k) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                max = Math.max(max, m[0] + m[1] - queue.peek()[0]);
            }
            queue.add(new int[]{m[0] - m[1], m[0]});
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {2, 0}, {5, 10}, {6, -10}};
        System.out.println(new T1499_findMaxValueOfEquation().findMaxValueOfEquation(points, 1));
    }
}
