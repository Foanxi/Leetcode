package middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author foanxi
 */
public class T2596_checkValidGrid {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0){
            return false;
        }
        Map<Integer, int[]> map = new HashMap<>();
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.put(grid[i][j], new int[]{i, j});
            }
        }
        int x = map.get(0)[0];
        int y = map.get(0)[1];
        for (int i = 1; i < n * n; i++) {
            int x1 = map.get(i)[0];
            int y1 = map.get(i)[1];
            if (!isValid(x, y, x1, y1)) {
                return false;
            }
            x = x1;
            y = y1;
        }
        return true;
    }

    public boolean isValid(int x, int y, int x1, int y1) {
        // 右竖下角
        if (Math.abs(x1 - x) == 1 && Math.abs(y1 - y) == 2) {
            return true;
        }
        if (Math.abs(x1 - x) == 2 && Math.abs(y1 - y) == 1) {
            return true;
        }
        return false;
    }
}
