package easy;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author hujinxu
 * @date 2023/7/24
 * @description
 */
public class T703_KthLargest {

    private Queue<Integer> queue;

    private int k;

    public T703_KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        this.k = k;
        for (int n : nums) {
            queue.add(n);
        }
    }

    public int add(int val) {
        queue.add(val);
        while (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        T703_KthLargest t703KthLargest = new T703_KthLargest(3, new int[]{4, 5, 8, 2});
        int add = t703KthLargest.add(3);
        System.out.println(add);
    }
}
