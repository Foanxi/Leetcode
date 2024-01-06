package middle;

import java.util.*;

public class T2397_maximumRows {
    int res = 0;
    int zero = 0;
    Map<Integer, Set<Integer>> map;

    public int maximumRows(int[][] matrix, int numSelect) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (col <= numSelect) {
            return row;
        }
        map = new HashMap<>();
        for (int i = 0; i < row; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    set.add(j);
                }
            }
            if (set.isEmpty()) {
                zero++;
            } else {
                map.put(i, set);
            }
        }
        traversal(matrix, new HashSet<>(), numSelect, -1);
        return res;
    }

    public void traversal(int[][] matrix, Set<Integer> choose, int last, int up) {
        if (last == 0) {
            int temp = zero;
            // 遍历当前选择了的列,判断有多少个成立的
            for (Map.Entry<Integer, Set<Integer>> integerSetEntry : map.entrySet()) {
                if (choose.containsAll(integerSetEntry.getValue())) {
                    temp++;
                }
            }
            res = Math.max(res, temp);
            return;
        }
        for (int i = up + 1; i < matrix[0].length; i++) {
            // 如果当前这一行没被选择过
            if (choose.contains(i)) {
                continue;
            }
            choose.add(i);
            traversal(matrix, choose, last - 1, i);
            choose.remove(i);
        }
    }
}
