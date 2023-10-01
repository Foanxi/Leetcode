package middle;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author foanxi
 */
public class T100076_minSizeSubarray {
    public int minSizeSubarray(int[] nums, int target) {
        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> out = new ArrayDeque<>();
        int res = Integer.MAX_VALUE;
        int index = 0;
        int sum = 0;
        while (sum < target) {
            for (int num : nums) {
                queue.add(num);
                sum += num;
            }
        }
        for (int num : nums) {
            queue.add(num);
            sum += num;
        }
        int cur = 0;
        int len = 0;
        while (!queue.isEmpty()) {
            while (!queue.isEmpty() && cur < target) {
                Integer poll = queue.poll();
                cur += poll;
                len++;
                out.add(poll);
            }
            if (cur == target) {
                res = Math.min(len, res);
                cur -= out.poll();
                len--;
            }
            while (!out.isEmpty() && cur > target) {
                cur -= out.poll();
                len--;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        System.out.println(new T100076_minSizeSubarray().minSizeSubarray(new int[]{1, 2, 3}, 5));
    }
}
