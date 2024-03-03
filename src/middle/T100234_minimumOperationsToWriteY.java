package middle;

import java.util.Arrays;

public class T100234_minimumOperationsToWriteY {
    public int minimumOperationsToWriteY(int[][] grid) {
        // 找出当前在y单元格上的值
        int len = grid.length;
        int[] yMap = new int[3];
        int[] otherMap = new int[3];
        boolean[][] visited = new boolean[len][len];
        int mid = len / 2;
        int sum = 0;
        int res = 0;
        // 左对角线
        for (int i = 0; i <= mid; i++) {
            yMap[grid[i][i]]++;
            visited[i][i] = true;
            sum++;
        }
        for (int i = 0, j = len - 1; j > mid; i++, j--) {
            yMap[grid[i][j]]++;
            sum++;
            visited[i][j] = true;
        }
        for (int t = mid + 1; t < len; t++) {
            sum++;
            yMap[grid[t][mid]]++;
            visited[t][mid] = true;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (visited[i][j]) {
                    continue;
                }
                otherMap[grid[i][j]]++;
            }
        }
        System.out.println(Arrays.toString(yMap));
        System.out.println(Arrays.toString(otherMap));
        // 先找出两个数组各自最大的元素，并查看是否相等，如果相等则考虑变换其中一个
        int[] compare = compare(yMap);
        int[] compare2 = compare(otherMap);
        if (compare[0] != compare2[0]) {
            return sum - yMap[compare[0]] + (len * len - sum) - otherMap[compare2[0]];
        } else {
            return Math.min(sum - yMap[compare[1]] + (len * len - sum) - otherMap[compare2[0]],
                    sum - yMap[compare[0]] + (len * len - sum) - otherMap[compare2[1]]);
        }
    }

    public int[] compare(int[] count) {
        int[] res = new int[2];
        int num1 = count[0];
        int num2 = count[1];
        int num3 = count[2];
        if (num1 >= num2 && num1 > num3) {
            if (num2 < num3) {
                res[1] = 2;
            } else {
                res[1] = 1;
            }
        } else if (num2 > num1 && num2 > num3) {
            res[0] = 1;
            if (num1 < num3) {
                res[1] = 2;
            }
        } else {
            res[0] = 2;
            if (num1 < num2) {
                res[1] = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,1}, {1, 0, 2}, {1, 1, 0}};
        System.out.println(new T100234_minimumOperationsToWriteY().minimumOperationsToWriteY(grid));

    }
}
