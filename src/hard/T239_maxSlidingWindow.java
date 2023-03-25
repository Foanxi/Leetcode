package hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author foanxi
 */
public class T239_maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        // 用于存储最大值结果
        int[] res = new int[len];
        int index = 0;
        MyQueue queue = new MyQueue();
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        res[index++] = queue.peek();
        for (int i = k; i < nums.length; i++) {
            queue.poll(nums[i - k]);
            queue.add(nums[i]);
            res[index++] = queue.peek();
        }
        return res;
    }

    static class MyQueue {
        Deque<Integer> queue = new LinkedList<>();

        void poll(int val) {
            if (!queue.isEmpty() && val == queue.peek()) {
                queue.poll();
            }
        }

        void add(int val) {
            while (!queue.isEmpty() && val > queue.getLast()) {
                queue.removeLast();
            }
            queue.add(val);
        }

        int peek() {
            return queue.peek();
        }
    }
}
