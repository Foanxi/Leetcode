package middle;

import java.util.*;

public class T100209_unmarkedSumArray {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        Set<Integer> marked = new HashSet<>();
        long[] res = new long[queries.length];
        long sum = 0;
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            queue.add(new int[]{nums[i], i});
        }
        for (int i = 0; i < queries.length && !queue.isEmpty(); i++) {
            int[] query = queries[i];
            if (!marked.contains(query[0])) {
                sum -= nums[query[0]];
                marked.add(query[0]);
            }
            for (int j = 0; j < query[1] && !queue.isEmpty(); j++) {
                int[] poll = queue.poll();
                while (!queue.isEmpty() && marked.contains(poll[1])) {
                    poll = queue.poll();
                }
                sum -= poll[0];
                marked.add(poll[1]);
            }
            res[i] = Math.max(0, sum);
        }
        return res;
    }
}
