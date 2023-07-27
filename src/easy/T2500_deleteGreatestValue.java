package easy;

import java.util.Arrays;

/**
 * @author hujinxu
 */
public class T2500_deleteGreatestValue {


    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int[] ints : grid) {
            Arrays.sort(ints);
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            int mx = 0;
            for (int[] ints : grid) {
                mx = Math.max(mx, ints[j]);
            }
            res += mx;
        }
        return res;
    }

    public int deleteGreatestValue2(int[][] grid) {
        int res = 0;
        boolean flag = true;
        while (flag) {
            int max = 0;
            for (int i = 0; i < grid.length; ++i) {
                int rowMax = 0;
                int rowIndex = -1;
                for (int j = 0; j < grid[i].length; ++j) {
                    if (rowMax < grid[i][j]) {
                        rowIndex = j;
                        rowMax = grid[i][j];
                    }
                }
                if (rowIndex == -1) {
                    flag = false;
                    break;
                }
                grid[i][rowIndex] = 0;
                max = Math.max(rowMax, max);
            }
            res += max;
        }
        return res;
    }

}
