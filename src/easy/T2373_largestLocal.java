package easy;

import java.util.Arrays;

public class T2373_largestLocal {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n - 2][n - 2];
        // 负责遍历行
        for (int row = 0; row < n - 2; row++) {
            for (int col = 0; col < n - 2; col++) {
                for (int i = row; i < row + 2 && i < n; i++) {
                    for (int j = col; j < col + 2 && j < n; j++) {
                        result[row][col] = Math.max(result[row][col], grid[i][j]);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new T2373_largestLocal().largestLocal(new int[][]{{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}})));
    }
}
