package hard;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author foanxi
 */
public class T630_scheduleCourse {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (o1, o2) -> o1[1] - o2[1]);
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int total = 0;
        for (int[] cours : courses) {
            if (cours[0] + total <= cours[1]) {
                queue.add(cours[0]);
                total += cours[0];
            } else if (!queue.isEmpty() && queue.peek() > cours[0]) {
                total -= queue.poll() - cours[0];
                queue.add(cours[0]);
            }

        }
        return queue.size();
    }
}
