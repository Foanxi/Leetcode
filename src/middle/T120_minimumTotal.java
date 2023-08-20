package middle;

import java.util.List;

public class T120_minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 可以左对齐来看三角形
        /*
        2
        3 4
        6 5 7
        4 1 8 3
        */
        if (triangle.size() <=1)
        int[][] dp = new int[triangle.size()][];
        for (int i = 0; i < triangle.size(); i++) {
            dp[i] = new int[i + 1];
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < i; j++) {
                dp[i][j] = list.get(0);
            }
        }
    }
}
