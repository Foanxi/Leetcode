package middle;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class T2865_maximumSumOfHeights {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long res = 0;
        long[] prefix = new long[n];
        long[] suffix = new long[n];
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack1.isEmpty() && maxHeights.get(i) < maxHeights.get(stack1.peek())) {
                stack1.pop();
            }
            if (stack1.isEmpty()) {
                prefix[i] = (long) (i + 1) * maxHeights.get(i);
            } else {
                prefix[i] = prefix[stack1.peek()] + (long) (i - stack1.peek()) * maxHeights.get(i);
            }
            stack1.push(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!stack2.isEmpty() && maxHeights.get(i) < maxHeights.get(stack2.peek())) {
                stack2.pop();
            }
            if (stack2.isEmpty()) {
                suffix[i] = (long) (n - i) * maxHeights.get(i);
            } else {
                suffix[i] = suffix[stack2.peek()] + (long) (stack2.peek() - i) * maxHeights.get(i);
            }
            stack2.push(i);
            res = Math.max(res, prefix[i] + suffix[i] - maxHeights.get(i));
        }
        return res;
    }

    public long maximumSumOfHeights2(List<Integer> maxHeights) {
        long res = 0;
        for (int i = 0; i < maxHeights.size(); i++) {
            int pre = maxHeights.get(i);
            long sum = 0;
            for (int j = i; j >= 0; j--) {
                pre = Math.min(maxHeights.get(j), pre);
                sum += pre;
            }
            pre = maxHeights.get(i);
            for (int j = i + 1; j < maxHeights.size(); j++) {
                pre = Math.min(pre, maxHeights.get(j));
                sum += pre;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T2865_maximumSumOfHeights().maximumSumOfHeights(Arrays.asList(6, 5, 3, 9, 2, 7)));
    }
}
