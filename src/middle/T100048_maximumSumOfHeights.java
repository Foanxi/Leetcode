package middle;

import java.util.Arrays;
import java.util.List;

/**
 * @author foanxi
 */
public class T100048_maximumSumOfHeights {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        int[][] minGrid = new int[n][n];
        for (int i = 0; i < maxHeights.size(); i++) {
            for (int j = i; j < maxHeights.size(); j++) {
                if (j == i) {
                    minGrid[i][j] = maxHeights.get(j);
                } else {
                    minGrid[i][j] = Math.min(maxHeights.get(j), minGrid[i][j - 1]);
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < maxHeights.size(); i++) {
            // 当选择i为山峰的时候
            // 先求行
            long temp = 0;
            for (int j = i; j < n; j++) {
                temp += minGrid[i][j];
            }
            // 再求列
            for (int j = 0; j < i; j++) {
                temp += minGrid[j][i];
            }
            sum = Math.max(sum, temp);
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 2, 4, 4);
        System.out.println(new T100048_maximumSumOfHeights().maximumSumOfHeights(list));
    }
}
