package easy;

import java.util.PriorityQueue;
import java.util.Queue;

public class T100231_minOperations {
    public int minOperations(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        int res = 0;
        for (int i : nums) {
            queue.add(i);
        }
        while (!queue.isEmpty() && queue.peek() < k) {
            queue.poll();
            res++;
        }
        return res;
    }
}
