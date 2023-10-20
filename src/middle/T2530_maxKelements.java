package middle;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author foanxi
 */
public class T2530_maxKelements {
    public long maxKelements(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int num : nums) {
            queue.add(num);
        }
        long res = 0;
        while (k > 0) {
            Integer poll = queue.poll();
            res += poll;
            queue.add((int) Math.ceil(poll / 3.0));
            k--;
        }
        return res;
    }
}
