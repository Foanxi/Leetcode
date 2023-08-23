package hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T1782_countPairs {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] count = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            count[x]++;
            count[y]++;
            int key = Math.min(x, y) * n + Math.max(x, y);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int[] arr = Arrays.copyOf(count, n);
        Arrays.sort(arr);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            // 首先找出严格大于queries[i]的位置
            int query = queries[i];
            int total = 0;
            for (int j = 0; j < n; j++) {
                int k = binarySearch(arr, query - arr[j], j + 1, n);
                total += n - k;
            }
            for (int num : map.keySet()) {
                int freq = map.get(num);
                int x = num / n, y = num % n;
                if (count[x] + count[y] > query && count[x] + count[y] - freq <= y) {
                    total--;
                }
            }
            res[i] = total;
        }
        return res;
    }

    public int binarySearch(int[] arr, int target, int left, int right) {
        int res = right;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
                res = mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1, 2}, {2, 4}, {1, 3}, {2, 3}, {2, 1}};
        System.out.println(Arrays.toString(new T1782_countPairs().countPairs(n, edges, new int[]{2, 3})));
    }
}
