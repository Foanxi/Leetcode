package offer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class T59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        int index = 1;
        for (int j = k; j < nums.length; j++) {
            if (!deque.isEmpty() && nums[j - k] == deque.peekFirst()) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[j] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.addLast(nums[j]);
            res[index] = deque.peekFirst();
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T59_1().maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)));
    }
}
