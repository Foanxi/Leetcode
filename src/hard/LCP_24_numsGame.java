package hard;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class LCP_24_numsGame {
    public int[] numsGame(int[] nums) {
        Queue<Integer> min = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Queue<Integer> max = new PriorityQueue<>();
        long minSum = 0;
        long maxSum = 0;
        int n = nums.length;
        int mod = 1_000_000_007;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = nums[i] - i;
            if (min.isEmpty() || min.peek() > cur) {
                min.add(cur);
                minSum += cur;
                if (min.size() > max.size() + 1) {
                    int peek = min.poll();
                    minSum -= peek;
                    maxSum += peek;
                    max.add(peek);
                }
            } else {
                max.add(cur);
                maxSum += cur;
                if (max.size() > min.size()) {
                    int peek = max.poll();
                    minSum += peek;
                    maxSum -= peek;
                    min.add(peek);
                }
            }
            res[i] = (int) ((i + 1) % 2 == 0 ? (maxSum - minSum) % mod : (maxSum - minSum + min.peek()) % mod);
        }
        return res;
    }

    public int[] numsGame2(int[] nums) {
        Queue<Integer> min = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Queue<Integer> max = new PriorityQueue<>();
        long minSum = 0;
        long maxSum = 0;
        int n = nums.length;
        int mod = 1_000_000_007;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            min.add(nums[i] - i);
            minSum += nums[i] - i;

            maxSum += min.peek();
            minSum -= min.peek();
            max.add(min.poll());

            if (max.size() > min.size()) {
                min.add(max.peek());
                maxSum -= max.peek();
                minSum += max.poll();
            }
            res[i] = (int) ((i + 1) % 2 == 0 ? (maxSum - minSum) % mod : (maxSum - minSum + min.peek()) % mod);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LCP_24_numsGame().numsGame(new int[]{3, 4, 5, 1, 6, 7})));
    }

}
