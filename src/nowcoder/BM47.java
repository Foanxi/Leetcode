package nowcoder;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author foanxi
 */
public class BM47 {
    public int findKth(int[] a, int n, int K) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < K; ++i) {
            queue.add(a[i]);
        }
        for (int i = K; i < n; ++i) {
            queue.add(a[i]);
            queue.poll();
        }
        return queue.poll();
    }
}
