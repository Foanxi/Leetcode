package easy;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author foanxi
 */
public class T2558_pickGifts {
    public long pickGifts(int[] gifts, int k) {
        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int num : gifts) {
            queue.add(num);
        }
        while (k-- > 0) {
            Integer poll = queue.poll();
            queue.add((int) Math.sqrt(poll));
        }
        long res = 0;
        while (!queue.isEmpty()) {
            res += queue.poll();
        }
        return res;
    }
}
