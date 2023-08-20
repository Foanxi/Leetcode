package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author foanxi
 */
public class T120_minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 可以左对齐来看三角形
        /*
        2
        3 4
        6 5 7
        4 1 8 3
        */
        if (triangle.size() <= 1) {
            return triangle.get(0).get(0);
        } else if (triangle.size() == 2) {
            return Math.min(triangle.get(1).get(0), triangle.get(1).get(1)) + triangle.get(0).get(0);
        }
        int[][] dp = new int[triangle.size()][];
        // 初始化
        dp[0] = new int[1];
        dp[0][0] = triangle.get(0).get(0);
        dp[1] = new int[2];
        dp[1][0] = triangle.get(1).get(0) + dp[0][0];
        dp[1][1] = triangle.get(1).get(1) + dp[0][0];
        for (int i = 2; i < triangle.size(); i++) {
            dp[i] = new int[i + 1];
            List<Integer> list = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + list.get(j);
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + list.get(j);
                } else {
                    dp[i][j] = list.get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int num : dp[triangle.size() - 1]) {
            min = Math.min(num, min);
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> q = new ArrayList<>();
        q.add(Collections.singletonList(2));
        q.add(Arrays.asList(3, 4));
        q.add(Arrays.asList(6, 5, 7));
        q.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new T120_minimumTotal().minimumTotal(q));
    }
}
