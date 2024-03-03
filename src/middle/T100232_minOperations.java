package middle;

import java.util.PriorityQueue;
import java.util.Queue;

public class T100232_minOperations {
    public int minOperations(int[] nums, int k) {
        Queue<Long> queue = new PriorityQueue<>();
        int res = 0;
        for (int i : nums) {
            queue.add((long) i);
        }
        while (queue.size() >= 2 && queue.peek() < k) {
            Long x = queue.poll();
            Long y = queue.poll();
            queue.add(Math.min(x, y) * 2 + Math.max(x, y));
            res++;
        }
        return res;
    }
}
