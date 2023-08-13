package hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author foanxi
 */
public class T239_maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0 || k > nums.length) {
            return new int[]{};
        }
        int index = 0;
        int[] res = new int[nums.length - k + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.pollLast();
            }
            queue.add(nums[i]);
        }
        res[index++] = queue.peek();
        for (int j = k; j < nums.length; j++) {
            if (queue.peek().equals(nums[j - k])) {
                queue.poll();
            }
            while (!queue.isEmpty() && queue.peekLast() < nums[j]) {
                queue.pollLast();
            }
            queue.add(nums[j]);
            res[index++] = queue.peek();
        }
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
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
