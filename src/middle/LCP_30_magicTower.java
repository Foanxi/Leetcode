package middle;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class LCP_30_magicTower {
    public int magicTower(int[] nums) {
        if (Arrays.stream(nums).sum() <= 0) {
            return -1;
        }
        long sum = 1;
        int res = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (num < 0) {
                queue.add(num);
            }
            sum += num;
            if (sum <= 0) {
                res++;
                if (queue.isEmpty()) {
                    return -1;
                } else {
                    sum -= queue.poll();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LCP_30_magicTower().magicTower(new int[]{-200, -300, 400, 0}));
    }
}
