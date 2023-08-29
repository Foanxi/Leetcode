package middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author foanxi
 */
public class T823_numFactoredBinaryTrees {
    public int numFactoredBinaryTrees(int[] arr) {
        final long mod = 1_000_000_000 + 7;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        long res = 0;
        Arrays.sort(arr);
        long[] dp = new long[arr.length];
        Arrays.fill(dp, -1);
        res += arr.length % mod;
        // 枚举当前arr数组中能够凑成当前的值
        // 第一个和第二个可以直接跳过记录为1，理由是因为从小到大排序，第一个和第二个必然无法凑成二叉树
        for (int i = 0; i < arr.length; i++) {
            res += dfs(i, map, dp, arr);
        }
        return (int) (res % mod);
    }

    public long dfs(int i, Map<Integer, Integer> map, long[] dp, int[] arr) {
        if (dp[i] != -1) {
            return dp[i];
        }
        long res = 0;
        for (int j = 0; j < i; j++) {
            if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) {
                res += dfs(map.get(arr[i] / arr[j]), map, dp, arr) * dfs(map.get(arr[i]), map, dp, arr);
            }
        }
        dp[i] = res;
        return res;
    }
}
